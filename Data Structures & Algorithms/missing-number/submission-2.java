class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            // Add the expected index, subtract the actual number
            result += (i - nums[i]);
        }
        
        return result;
    }
}
