class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            int l = n - i - 1;
            for (int j = 0; j < l-i; j++) {
                int t = matrix[i][i+j];
                matrix[i][i+j] = matrix[l-j][i];
                matrix[l-j][i] = matrix[l][l - j];
                matrix[l][l - j] = matrix[i+j][l];
                matrix[i+j][l] = t;
            }
        }
    }
}
