class Solution {
    public boolean canJump(int[] nums) {
      int maxReach = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // If the current index is beyond our max reach, we are stuck
            if (i > maxReach) return false;
            
            // Update the furthest we can reach
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }
            
            // Early exit: if we can already reach the end, stop looping
            if (maxReach >= n - 1) return true;
        }
        
        return true;
    }
}
