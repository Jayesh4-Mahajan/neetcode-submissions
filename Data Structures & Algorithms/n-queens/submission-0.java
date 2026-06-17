class Solution {

    private List<List<String>> res;
    private Map<String, Set<Integer>> blocks;

    public List<List<String>> solveNQueens(int n) {
        
        res = new ArrayList<>();
        blocks = new HashMap<>();
        blocks.put("rows", new HashSet());
        blocks.put("cols", new HashSet());
        blocks.put("dl", new HashSet());
        blocks.put("dr", new HashSet());
        List<String> board = generateBoard(n);
        backtrack(0, n, board);
        return res;
    }

    private void backtrack(int ind, int n, List<String> board) {
        if (ind == n) {
            res.add(new ArrayList(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (blocks.get("rows").contains(ind)) {
                continue;
            }
            if (blocks.get("cols").contains(i)) {
                continue;
            }
            if (blocks.get("dl").contains(i - ind)) {
                continue;
            }
            if (blocks.get("dr").contains(i + ind)) {
                continue;
            }
            board.set(ind, board.get(ind).substring(0, i) + "Q" + board.get(ind).substring(i + 1));
            blocks.get("rows").add(ind);
            blocks.get("cols").add(i);
            blocks.get("dl").add(i - ind);
            blocks.get("dr").add(i + ind);

            backtrack(ind+1, n, board);

            board.set(ind, board.get(ind).substring(0, i) + "." + board.get(ind).substring(i + 1));
            blocks.get("rows").remove(ind);
            blocks.get("cols").remove(i);
            blocks.get("dl").remove(i - ind);
            blocks.get("dr").remove(i + ind);
        }
    }

    private List<String> generateBoard(int n) {
        List<String> board = new ArrayList<>();
        String a = "";
        for (int i = 0; i<n ; i++) {
            board.add(".".repeat(n));
        }
        return board;
    }
}
