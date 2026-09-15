class Solution {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        int eSum = (l)*(l+1)/2;
        int aSum = 0;
        for (int n: nums){
            aSum+=n;
        }
        return eSum - aSum;
    }
}
