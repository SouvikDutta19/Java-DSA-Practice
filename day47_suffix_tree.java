import java.util.*;

class SuffixTreeNode {
    Map<Character, SuffixTreeNode> children = new HashMap<>();
    boolean isEnd;

    public void insertSuffix(String s) {
        if (s.length() > 0) {
            char c = s.charAt(0);
            children.putIfAbsent(c, new SuffixTreeNode());
            children.get(c).insertSuffix(s.substring(1));
        } else {
            isEnd = true;
        }
    }
}

public class day47_suffix_tree {
    private final SuffixTreeNode root = new SuffixTreeNode();

    public day47_suffix_tree(String txt) {
        for (int i = 0; i < txt.length(); i++) {
            root.insertSuffix(txt.substring(i));
        }
    }

    public boolean search(String pat) {
        SuffixTreeNode node = root;
        for (char c : pat.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "bananas";
        day47_suffix_tree tree = new day47_suffix_tree(text);
        System.out.println("Searching 'ana': " + tree.search("ana"));
        System.out.println("Searching 'apple': " + tree.search("apple"));
    }
}
