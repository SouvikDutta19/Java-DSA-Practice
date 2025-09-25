import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    TrieNode fail;
    List<String> output = new ArrayList<>();
}

public class day90_aho_corasick {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.output.add(word);
    }

    void buildFailureLinks() {
        Queue<TrieNode> q = new LinkedList<>();
        for (TrieNode node : root.children.values()) {
            node.fail = root;
            q.add(node);
        }
        while (!q.isEmpty()) {
            TrieNode cur = q.poll();
            for (Map.Entry<Character, TrieNode> e : cur.children.entrySet()) {
                char c = e.getKey();
                TrieNode child = e.getValue();
                TrieNode f = cur.fail;
                while (f != null && !f.children.containsKey(c)) f = f.fail;
                child.fail = (f == null) ? root : f.children.get(c);
                child.output.addAll(child.fail.output);
                q.add(child);
            }
        }
    }

    void search(String text) {
        TrieNode node = root;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            while (node != root && !node.children.containsKey(c)) node = node.fail;
            node = node.children.getOrDefault(c, root);
            if (!node.output.isEmpty()) {
                for (String pattern : node.output)
                    System.out.println("Found pattern \"" + pattern + "\" at index " + (i - pattern.length() + 1));
            }
        }
    }

    public static void main(String[] args) {
        day90_aho_corasick ac = new day90_aho_corasick();
        ac.insert("he");
        ac.insert("she");
        ac.insert("his");
        ac.insert("hers");
        ac.buildFailureLinks();
        ac.search("ahishers");
    }
}
