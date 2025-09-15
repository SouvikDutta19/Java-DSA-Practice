import java.util.*;

public class day78_word_ladder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps = 1;
        while(!q.isEmpty()) {
            for(int i=0;i<q.size();i++) {
                String word = q.poll();
                if(word.equals(endWord)) return steps;
                char[] arr = word.toCharArray();
                for(int j=0;j<arr.length;j++) {
                    char orig = arr[j];
                    for(char c='a';c<='z';c++) {
                        arr[j]=c;
                        String next=new String(arr);
                        if(dict.contains(next)) {
                            q.offer(next);
                            dict.remove(next);
                        }
                    }
                    arr[j]=orig;
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Word Ladder Length: " + ladderLength("hit","cog",words));
    }
}
