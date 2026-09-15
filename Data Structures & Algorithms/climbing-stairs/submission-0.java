class Solution {
    public int climbStairs(int n) {
        if(n<4) return n;
        int o = 1;
        int t = 2;
        int s;
        for (int i = 2;i<n;i++){
            s = t;
            t = t+o;
            o = s;
        }
        return t;
    }
}
