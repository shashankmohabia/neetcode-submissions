class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        if (m == 0) return result;
        
        int n = heights[0].length;
        
        // Using boolean arrays for memory efficiency and clarity
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];        

        Queue<int[]> queue = new ArrayDeque<>();
        
        // Initialize Pacific coastline
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, 0});
            p[i][0] = true;
        }
        for (int i = 1; i < n; i++) { // Start at 1 to avoid duplicating (0,0)
            queue.offer(new int[]{0, i});
            p[0][i] = true;
        }
        
        process(queue, p, heights, m, n);

        // Initialize Atlantic coastline
        for (int i = 0; i < m; i++) {
            queue.offer(new int[]{i, n - 1});
            a[i][n - 1] = true;
        }
        for (int i = 0; i < n - 1; i++) { // Start at 0 to n-2 to avoid duplicating (m-1, n-1)
            queue.offer(new int[]{m - 1, i});
            a[m - 1][i] = true;
        }
        
        process(queue, a, heights, m, n);
        
        // Find cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (p[i][j] && a[i][j]) {
                    result.add(Arrays.asList(i, j));
               }
            }
        }
        
        return result;
    }

    private void process(Queue<int[]> queue, boolean[][] t, int[][] heights, int m, int n) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
        
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            int v = heights[i][j];
            
            for (int[] d : dirs) {
                int r = i + d[0];
                int c = j + d[1];
                
                // Check boundaries, elevation, and visited state
                if (r >= 0 && r < m && c >= 0 && c < n && heights[r][c] >= v && !t[r][c]) {
                    queue.offer(new int[]{r, c});
                    t[r][c] = true;
                }
            }
        }
    }
}