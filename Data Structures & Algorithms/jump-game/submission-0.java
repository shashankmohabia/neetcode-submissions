class Solution {
    public boolean canJump(int[] nums) {
       int n = nums.length;
        if (n == 1) return true;
        boolean[] canJump = new boolean[n];
        canJump[n-1] = true;
        for (int i = n-2; i >= 0; i--) {
            for (int j = Math.min(i + nums[i], n-1); j > i; j--){
                if (canJump[j]) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[0]; 
    }
}
