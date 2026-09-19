class Solution {

    private void process(Queue<int[]> queue, int[][] t, int[][] heights, int m, int n) {
        while(!queue.isEmpty()) {
            int[] c = queue.poll();
            int i = c[0];
            int j = c[1];
            int v = heights[i][j];
            if (i+1 < m && v <= heights[i+1][j] && t[i+1][j] != 1) {
                queue.offer(new int[]{i+1, j});
                t[i+1][j] = 1;
            }
            if (i-1 > -1 && v <= heights[i-1][j] && t[i-1][j] != 1) {
                queue.offer(new int[]{i-1, j});
                t[i-1][j] = 1;
            }
            if (j-1 > -1 && v <= heights[i][j-1] && t[i][j-1] != 1) {
                queue.offer(new int[]{i, j-1});
                t[i][j-1] = 1;
            }
            if (j+1 < n && v <= heights[i][j+1] && t[i][j+1] != 1) {
                queue.offer(new int[]{i, j+1});
                t[i][j+1] = 1;
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

