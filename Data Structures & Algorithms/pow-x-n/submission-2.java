class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (x == 0) return 0;
        // Calculate half power once
        double half = myPow(x, n / 2);
        
        // If n is even, it's just half * half
        if (n % 2 == 0) {
            return half * half;
        } 
        // If n is odd, multiply by x (handle negative n as well)
        else {
            if (n > 0) return half * half * x;
            else return half * half / x;
        }
    }
}
