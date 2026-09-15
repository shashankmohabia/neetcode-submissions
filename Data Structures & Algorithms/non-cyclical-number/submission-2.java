class Solution {
    public boolean isHappy(int n) {
         while(n!=1 && n != 4){
            int current = n;
            int sum = 0;
            while (current > 0) {
                int digit = current % 10;  // 1. Pull off the rightmost digit
                sum += digit * digit;      // 2. Square it and add to sum
                current /= 10;             // 3. Chop off that digit and repeat
            }
            n = sum;
        }
        return n==1;
    }
}
