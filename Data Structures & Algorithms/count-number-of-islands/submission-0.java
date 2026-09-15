class Solution {

    private void resetIsland(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i >= grid.length || j >= grid[0].length) return;
        if (grid [i][j]=='0') return;
        grid[i][j] = '0';
        resetIsland(grid, i+1, j);
        resetIsland(grid, i-1, j);
        resetIsland(grid, i, j+1);
        resetIsland(grid, i, j-1);
    }

    public int numIslands(char[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid [i][j] == '1') {
                    answer++;
                    resetIsland(grid, i, j);
                }
            }
        }
        return answer;
    }
}
