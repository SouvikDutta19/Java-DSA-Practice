import java.util.*;

class State {
    int len, link;
    Map<Character,Integer> next=new HashMap<>();
}

public class day70_suffix_automaton {
    List<State> st=new ArrayList<>();
    int last;

    day70_suffix_automaton(String s){
        st.add(new State()); last=0;
        for(char c:s.toCharArray()) extend(c);
    }

    void extend(char c){
        int cur=st.size();
        State sc=new State(); sc.len=st.get(last).len+1;
        st.add(sc);
        int p=last;
        while(p!=-1 && !st.get(p).next.containsKey(c)){
            st.get(p).next.put(c,cur);
            p=st.get(p).link;
        }
        if(p==-1) st.get(cur).link=0;
        else{
            int q=st.get(p).next.get(c);
            if(st.get(p).len+1==st.get(q).len) st.get(cur).link=q;
            else{
                int clone=st.size();
                State qc=new State();
                qc.len=st.get(p).len+1; qc.next.putAll(st.get(q).next); qc.link=st.get(q).link;
                st.add(qc);
                while(p!=-1 && st.get(p).next.get(c)==q){
                    st.get(p).next.put(c,clone); p=st.get(p).link;
                }
                st.get(q).link=st.get(cur).link=clone;
            }
        }
        last=cur;
    }

    public static void main(String[] args){
        day70_suffix_automaton sa=new day70_suffix_automaton("ababa");
        System.out.println("Suffix automaton built with "+sa.st.size()+" states");
    }
}
