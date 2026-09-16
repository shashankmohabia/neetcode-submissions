class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            
            // Target found!
            if (nums[m] == target) {
                return m;
            }
            
            // Check if the left half is the sorted one
            if (nums[s] <= nums[m]) {
                // Is the target strictly within this sorted left half?
                if (target >= nums[s] && target < nums[m]) {
                    e = m - 1; // Search left
                } else {
                    s = m + 1; // Search right
                }
            } 
            // Otherwise, the right half MUST be the sorted one
            else {
                // Is the target strictly within this sorted right half?
                if (target > nums[m] && target <= nums[e]) {
                    s = m + 1; // Search right
                } else {
                    e = m - 1; // Search left
                }
            }
        }
        
        // Target not found
        return -1;
    }
}