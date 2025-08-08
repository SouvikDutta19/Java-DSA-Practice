// Trie Data Structure - Telephone Directory Search Suggestions

import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

public class day39_trietreetelephonedirectory {
    TrieNode root = new TrieNode();

    public void insert(String contact) {
        TrieNode node = root;
        for (char ch : contact.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    private void suggestionsRec(TrieNode node, String prefix, List<String> result) {
        if (node.isEndOfWord)
            result.add(prefix);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int idx = ch - 'a';
            if (node.children[idx] != null)
                suggestionsRec(node.children[idx], prefix + ch, result);
        }
    }

    public List<List<String>> displayContacts(String[] contacts, String query) {
        for (String contact : contacts)
            insert(contact);

        List<List<String>> output = new ArrayList<>();
        TrieNode node = root;
        String prefix = "";

        for (char ch : query.toCharArray()) {
            prefix += ch;
            int index = ch - 'a';
            if (node.children[index] == null) {
                while (output.size() < query.length()) output.add(List.of("0"));
                break;
            }
            node = node.children[index];
            List<String> suggestions = new ArrayList<>();
            suggestionsRec(node, prefix, suggestions);
            output.add(suggestions);
        }
        return output;
    }

    public static void main(String[] args) {
        String[] contacts = {"alice", "ali", "allen", "bob", "bobby", "charlie"};
        String query = "al";

        day39_trietreetelephonedirectory directory = new day39_trietreetelephonedirectory();
        List<List<String>> results = directory.displayContacts(contacts, query);

        int i = 1;
        for (List<String> suggestions : results) {
            System.out.println("Suggestions after typing '" + query.substring(0, i++) + "': " + suggestions);
        }
    }
}
