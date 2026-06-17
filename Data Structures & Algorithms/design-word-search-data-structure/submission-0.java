public class TrieNode {
    boolean endOfWord;
    TrieNode[] next;

    TrieNode(boolean endOfWord) {
        this.endOfWord = endOfWord;
        this.next = new TrieNode[26];
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode(false);
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()) {
            int ind = ch - 'a';
            if (curr.next[ind] == null) {
                curr.next[ind] = new TrieNode(false);
            }
            curr = curr.next[ind];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode cur = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child: cur.next) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.next[c - 'a'] == null) {
                    return false;
                }
                cur = cur.next[c - 'a'];
            }
        }
        return cur.endOfWord;
    }
}
