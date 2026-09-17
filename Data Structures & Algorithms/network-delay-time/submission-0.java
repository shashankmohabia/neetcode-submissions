class Solution {
    class Data {
        int destination;
        int distanceTillNow;
        public Data(int a,int c){
            this.destination = a;
            this.distanceTillNow = c;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> al = new HashMap<>();
        for (int i = 0; i< times.length; i++){
            List<int[]> l = al.getOrDefault(times[i][0], new ArrayList<>());
            l.add(new int[] {times[i][1], times[i][2]});
            al.put(times[i][0], l);
        }

        int[] v = new int[n];

        int result = Integer.MAX_VALUE;

        PriorityQueue<Data> q = new PriorityQueue<>((a, b) -> Integer.compare(a.distanceTillNow, b.distanceTillNow));
        q.add(new Data(k, 0));
        while(!q.isEmpty()) {
            Data d = q.poll();
            if(v[d.destination -1] == 0) {
            v[d.destination -1] = 1;
            result = d.distanceTillNow;
            al.getOrDefault(d.destination, new ArrayList<int[]>()).forEach(a->{
                q.add(new Data(a[0], d.distanceTillNow + a[1]));
            });
            }
        }

        // making sure all were visited
        for(int i = 0;i<n;i++){
            if (v[i] == 0) return -1;
        }
        
        return result;
    }
}
