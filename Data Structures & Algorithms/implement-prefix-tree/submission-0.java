public class TreeNode {
    boolean terminates;
    TreeNode[] tree;

    TreeNode(boolean terminates) {
        this.terminates = terminates;
        this.tree = new TreeNode[26];
    }
}

class PrefixTree {

    private TreeNode[] tree;

    public PrefixTree() {
        tree = new TreeNode[26];
    }

    public void insert(String word) {
        TreeNode[] curr = tree;
        for (int i=0; i<word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (curr[ind] == null) {
                curr[ind] = new TreeNode(false);
            }
            if (i == word.length() - 1) {
                curr[ind].terminates = true;
            }
            curr = curr[ind].tree;
        }
    }

    public boolean search(String word) {
        TreeNode last = null;
        TreeNode[] curr = tree;
        for (char ch : word.toCharArray()) {
            int ind = ch - 'a';
            if (curr[ind] == null) return false;
            last = curr[ind];
            curr = last.tree;
        }
        return last != null && last.terminates;
    }

    public boolean startsWith(String prefix) {
        TreeNode[] curr = tree;
        for (char ch : prefix.toCharArray()) {
            int ind = ch - 'a';
            if (curr[ind] == null) return false;
            curr = curr[ind].tree;
        }
        return true;
    }
}
