class Solution {

    private void process(Queue<int[]> queue, int[][] t, int[][] heights, int m, int n) {
    // Up, Down, Left, Right
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
    
    while(!queue.isEmpty()) {
        int[] cell = queue.poll();
        int i = cell[0], j = cell[1];
        int v = heights[i][j];
        
        for (int[] d : dirs) {
            int r = i + d[0];
            int c = j + d[1];
            
            // Check boundaries, elevation, and visited state in one clean line
            if (r >= 0 && r < m && c >= 0 && c < n && heights[r][c] >= v && t[r][c]==0) {
                queue.offer(new int[]{r, c});
                t[r][c] = 1;
            }
        }
    }
}

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;

        if (m == 0) return result;
        
        int n = heights[0].length;
        int[][] p = new int[m][n];
        int[][] a = new int[m][n];        

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0;i<m;i++){
            queue.offer(new int[]{i, 0});
            p[i][0] = 1;
        }
        
        for (int i = 1;i<n;i++){
            queue.offer(new int[]{0, i});
            p[0][i] = 1;
        }

        process(queue, p, heights, m, n);

        for (int i = 0;i<m;i++){
            queue.offer(new int[]{i, n-1});
            a[i][n-1] = 1;
        }
        
        for (int i = 0;i<n-1;i++){
            queue.offer(new int[]{m-1, i});
            a[m-1][i] = 1;
        }

        process(queue, a, heights, m, n);
        
        for (int i =0;i<m;i++) {
            for (int j =0;j<n;j++){
               if (p[i][j] == 1 && a[i][j]==1) {
                result.add(Arrays.asList(i, j));
               }
            }
        }
        return result;
    }
}

