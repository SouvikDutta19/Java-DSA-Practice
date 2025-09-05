import java.io.*;
import java.util.*;

/**
 * Splay Tree with order-statistic operations:
 *  - insert x
 *  - erase x (if exists)
 *  - kth(k): k-th smallest (1-indexed)
 *  - rank(x): #elements < x
 */
public class day67_splay_tree_order_statistic {
    static class Node {
        int key, cnt = 1, sz = 1;
        Node left, right, parent;
        Node(int key) { this.key = key; }
    }
    static Node root;

    static int size(Node x){ return x==null?0:x.sz; }
    static void pull(Node x){ if(x!=null) x.sz = x.cnt + size(x.left) + size(x.right); }
    static boolean isRoot(Node x){ return x.parent==null || (x.parent.left!=x && x.parent.right!=x); }

    static void rotate(Node x){
        Node p = x.parent, g = p.parent;
        if(!isRoot(p)) { if(g.left==p) g.left=x; else g.right=x; }
        x.parent=g;
        if(p.left==x){
            p.left=x.right; if(x.right!=null)x.right.parent=p;
            x.right=p; p.parent=x;
        }else{
            p.right=x.left; if(x.left!=null)x.left.parent=p;
            x.left=p; p.parent=x;
        }
        pull(p); pull(x);
    }
    static void splay(Node x){
        while(!isRoot(x)){
            Node p=x.parent,g=p.parent;
            if(!isRoot(p)) {
                if((g.left==p)==(p.left==x)) rotate(p);
                else rotate(x);
            }
            rotate(x);
        }
        root=x;
    }

    static Node lowerBound(int key){ // first node with key >= target
        Node cur=root, ans=null;
        while(cur!=null){
            if(key<=cur.key){ ans=cur; cur=cur.left; }
            else cur=cur.right;
        }
        return ans;
    }

    static void insert(int key){
        if(root==null){ root=new Node(key); return; }
        Node cur=root, p=null;
        while(cur!=null){
            p=cur;
            if(key==cur.key){ cur.cnt++; pull(cur); splay(cur); return; }
            else if(key<cur.key) cur=cur.left;
            else cur=cur.right;
        }
        Node x=new Node(key); x.parent=p;
        if(key<p.key) p.left=x; else p.right=x;
        splay(x);
    }

    static void erase(int key){
        Node x = lowerBound(key);
        if(x==null || x.key!=key) return;
        splay(x);
        if(x.cnt>1){ x.cnt--; pull(x); return; }
        if(x.left==null){ root=x.right; if(root!=null) root.parent=null; }
        else{
            Node y=x.left; while(y.right!=null) y=y.right;
            splay(y);
            y.right=x.right; if(y.right!=null) y.right.parent=y;
            pull(y); root=y; root.parent=null;
        }
    }

    static int rankOf(int key){ // #elements < key
        int res=0; Node cur=root;
        while(cur!=null){
            if(key<=cur.key) cur=cur.left;
            else { res += size(cur.left) + cur.cnt; cur=cur.right; }
        }
        return res;
    }

    static int kth(int k){ // 1-indexed
        Node cur=root;
        if(cur==null || k<=0 || k>size(cur)) return Integer.MIN_VALUE;
        while(true){
            if(k<=size(cur.left)) cur=cur.left;
            else if(k<=size(cur.left)+cur.cnt) { splay(cur); return cur.key; }
            else { k -= size(cur.left)+cur.cnt; cur=cur.right; }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine().trim());
        StringBuilder out=new StringBuilder();
        while(q-- > 0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            if(t==1) insert(x);
            else if(t==2) erase(x);
            else if(t==3) out.append(kth(x)).append('\n');
            else out.append(rankOf(x)).append('\n');
        }
        System.out.print(out.toString());
    }
}
