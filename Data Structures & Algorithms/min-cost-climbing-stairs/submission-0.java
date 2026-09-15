class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        if(l < 2) return cost[0];
        int last = cost[0];
        int last2last = 0;
        int current;
        for (int i=1;i<l;i++) {
            current = Math.min(last, last2last) + cost[i];
            last2last = last;
            last = current;
        }
        return Math.min(last, last2last);
    }
}
