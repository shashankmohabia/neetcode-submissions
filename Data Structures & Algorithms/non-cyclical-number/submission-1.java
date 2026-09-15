class Solution {
    public boolean isHappy(int n) {
        int slow = n;                  // The tortoise starts at the beginning
        int fast = getNext(n);         // The hare starts one step ahead
        
        // They keep running until the hare finds 1, or they crash into each other
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);               // Tortoise takes 1 step
            fast = getNext(getNext(fast));      // Hare takes 2 steps
        }
        
        // If the loop broke because the hare found 1, it's a happy number!
        return fast == 1;
    }
    
    // Our clean, reusable math helper
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
