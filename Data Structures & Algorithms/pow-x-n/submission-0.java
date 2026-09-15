class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double answer = x;
        if (n < 0) {
            while (n < 1) {
                answer /= x;
                n++;
            }
        } else {
            while (n > 1) {
                answer *= x;
                n--;
            }
        }
        return answer;
    }
}
