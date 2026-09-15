class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            // XOR the current result with the index AND the array value
            result ^= i ^ nums[i];
        }
        
        return result;
    }
}
