import java.util.*;

public class Day23_AhoCorasickAlgorithm {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode failLink = null;
        List<String> output = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.output.add(word);
    }

    public void buildFailLinks() {
        Queue<TrieNode> queue = new LinkedList<>();
        root.failLink = root;
        queue.add(root);

        while (!queue.isEmpty()) {
            TrieNode current = queue.poll();
            for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
                char ch = entry.getKey();
                TrieNode child = entry.getValue();

                TrieNode fail = current.failLink;
                while (fail != root && !fail.children.containsKey(ch)) {
                    fail = fail.failLink;
                }

                if (fail.children.containsKey(ch) && fail.children.get(ch) != child) {
                    child.failLink = fail.children.get(ch);
                } else {
                    child.failLink = root;
                }

                child.output.addAll(child.failLink.output);
                queue.add(child);
            }
        }
    }

    public void search(String text) {
        TrieNode node = root;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            while (node != root && !node.children.containsKey(ch)) {
                node = node.failLink;
            }

            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
            }

            for (String match : node.output) {
                System.out.println("Match found: " + match + " at position " + (i - match.length() + 1));
            }
        }
    }

    public static void main(String[] args) {
        Day23_AhoCorasickAlgorithm ac = new Day23_AhoCorasickAlgorithm();
        ac.insert("he");
        ac.insert("she");
        ac.insert("his");
        ac.insert("hers");

        ac.buildFailLinks();
        ac.search("ahishers");
    }
}
