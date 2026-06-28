class Solution {
    public boolean isValidSudoku(char[][] board) {
        // hashmap -> key: index, value: hashset of values
        HashMap<Integer, Set<Integer>> rows = new HashMap<>();
        HashMap<Integer, Set<Integer>> cols = new HashMap<>();
        HashMap<Integer, Set<Integer>> grids = new HashMap<>();

        // go through each box in the grid and
        // check if there is a num it should be unique within
        // the rows, cols and grids index. if not return false;
        // if unique add to the hashmaps and continue to the next index.
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] == '.') continue;
                int curr = board[row][col] - '0';
                int boxRow = row / 3;
                int boxCol = col / 3;
                int box = boxRow * 3 + boxCol;
                if ((rows.containsKey(row) && rows.get(row).contains(curr)) 
                    || (cols.containsKey(col) && cols.get(col).contains(curr))
                    || (grids.containsKey(box) && grids.get(box).contains(curr))) {
                    return false;
                } else {
                    rows.computeIfAbsent(row, k -> new HashSet<>()).add(curr);
                    cols.computeIfAbsent(col, k -> new HashSet<>()).add(curr);
                    grids.computeIfAbsent(box, k -> new HashSet<>()).add(curr);
                }
            }
        }

        return true;
    }
}
