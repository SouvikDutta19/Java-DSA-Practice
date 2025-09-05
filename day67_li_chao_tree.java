import java.io.*;
import java.util.*;

/**
 * Li Chao Tree (dynamic) for minimum queries of lines y = m*x + b.
 * Supports:
 *  - addLine(m, b)
 *  - query(x) -> min y over all lines at x
 *
 * Domain is long; set bounds accordingly.
 */
public class day67_li_chao_tree {
    static class Line {
        long m, b;
        Line(long m,long b){ this.m=m; this.b=b; }
        long f(long x){ return m*x + b; }
    }
    static class Node {
        Line ln;
        Node left, right;
        Node(Line ln){ this.ln=ln; }
    }

    static class LiChao {
        final long L, R;
        Node root;
        LiChao(long L,long R){ this.L=L; this.R=R; root=null; }
        void addLine(long m,long b){ root = addLine(root, L, R, new Line(m,b)); }
        Node addLine(Node cur,long l,long r,Line nl){
            if(cur==null) return new Node(nl);
            long mid = l + ((r - l) >> 1);
            boolean lef = nl.f(l) < cur.ln.f(l);
            boolean midBetter = nl.f(mid) < cur.ln.f(mid);
            if(midBetter){
                Line tmp = cur.ln; cur.ln = nl; nl = tmp;
            }
            if(r==l) return cur;
            if(lef != midBetter){
                cur.left = addLine(cur.left, l, mid, nl);
            } else {
                cur.right = addLine(cur.right, mid+1, r, nl);
            }
            return cur;
        }
        long query(long x){ return query(root, L, R, x); }
        long query(Node cur,long l,long r,long x){
            if(cur==null) return Long.MAX_VALUE/4;
            long res = cur.ln.f(x);
            if(l==r) return res;
            long mid = l + ((r - l) >> 1);
            if(x<=mid) return Math.min(res, query(cur.left, l, mid, x));
            else return Math.min(res, query(cur.right, mid+1, r, x));
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long L=Long.parseLong(st.nextToken()), R=Long.parseLong(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        LiChao lc=new LiChao(L,R);
        StringBuilder out=new StringBuilder();
        while(q-- > 0){
            st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            if(t==1){
                long m=Long.parseLong(st.nextToken()), b=Long.parseLong(st.nextToken());
                lc.addLine(m,b);
            }else{
                long x=Long.parseLong(st.nextToken());
                out.append(lc.query(x)).append('\n');
            }
        }
        System.out.print(out.toString());
    }
}
