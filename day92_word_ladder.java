import java.util.*;

public class day92_word_ladder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                String word = q.poll();
                if (word.equals(endWord)) return level;
                char[] arr = word.toCharArray();
                for (int j=0;j<arr.length;j++) {
                    char old = arr[j];
                    for (char c='a';c<='z';c++) {
                        arr[j]=c;
                        String next=new String(arr);
                        if(dict.remove(next)) q.add(next);
                    }
                    arr[j]=old;
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args){
        List<String> words=Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength("hit","cog",words));
    }
}
