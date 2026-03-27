import java.util.*;

public class day204_word_ladder_ii {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if(!dict.contains(endWord))
            return result;

        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();

        bfs(beginWord, endWord, dict, adj, level);

        List<String> path = new ArrayList<>();
        path.add(beginWord);

        dfs(beginWord, endWord, adj, level, path, result);

        return result;
    }

    static void bfs(String beginWord, String endWord, Set<String> dict,
                    Map<String, List<String>> adj,
                    Map<String, Integer> level){

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        level.put(beginWord, 0);

        while(!q.isEmpty()){

            String word = q.poll();
            int currLevel = level.get(word);

            char[] arr = word.toCharArray();

            for(int i=0;i<arr.length;i++){

                char original = arr[i];

                for(char c='a'; c<='z'; c++){

                    arr[i] = c;
                    String next = new String(arr);

                    if(dict.contains(next)){

                        adj.putIfAbsent(word, new ArrayList<>());
                        adj.get(word).add(next);

                        if(!level.containsKey(next)){
                            level.put(next, currLevel + 1);
                            q.add(next);
                        }
                    }
                }
                arr[i] = original;
            }
        }
    }

    static void dfs(String curr, String endWord,
                    Map<String, List<String>> adj,
                    Map<String, Integer> level,
                    List<String> path,
                    List<List<String>> result){

        if(curr.equals(endWord)){
            result.add(new ArrayList<>(path));
            return;
        }

        if(!adj.containsKey(curr))
            return;

        for(String next : adj.get(curr)){

            if(level.get(next) == level.get(curr) + 1){

                path.add(next);
                dfs(next, endWord, adj, level, path, result);
                path.remove(path.size()-1);
            }
        }
    }
}