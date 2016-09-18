import java.util.ArrayList;
import java.util.List;

public class FindWordsInGrid {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> foundStrings = new ArrayList<>();
        TrieNode trieNode = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trieNode, foundStrings);
            }
        }
        return foundStrings;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> foundStrings) {
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }
        TrieNode node = root.children[c - 'a'];
        if (node.word != null) {
            foundStrings.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i < board.length - 1) dfs(board, i + 1, j, node, foundStrings);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, foundStrings);
        if (i > 0) dfs(board, i - 1, j, node, foundStrings);
        if (j > 0) dfs(board, i, j - 1, node, foundStrings);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

    private class TrieNode {
        public TrieNode[] children = new TrieNode[27];
        public String word = null;
    }
}