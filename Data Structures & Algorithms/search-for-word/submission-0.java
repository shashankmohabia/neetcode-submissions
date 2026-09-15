class Solution {

    private boolean checkEx(char[][] board, int i, int j, String word, int c) {
        if (word.length() == c) return true;
        if (i<0 || j < 0 ||i>=board.length || j>=board[0].length) return false;
        if (word.charAt(c) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean verdict = checkEx(board, i+1, j, word, c+1) || checkEx(board, i-1, j, word, c+1) || checkEx(board, i, j+1, word, c+1) || checkEx(board, i, j-1, word, c+1);
        board[i][j] = temp;
        return verdict;
    }

    public boolean exist(char[][] board, String word) {
        int l = board.length;
        int d = board[0].length;
        int s = word.length();
        if (s > l*d) return false;

        for (int i = 0;i < l; i++) {
            for (int j = 0; j < d; j++) {
                if (checkEx(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
