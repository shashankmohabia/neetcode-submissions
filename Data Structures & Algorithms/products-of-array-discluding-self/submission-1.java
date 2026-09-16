class Solution {
    public int[] productExceptSelf(int[] nums) {
        int s = nums.length;
        int[] answer = new int[s];
        answer[0] = 1;
        for (int i = 1; i <= s - 1; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }
        
        int r = nums[s-1];

        for (int i = s-2; i>=0 ; i--)
        {
            answer[i] = r * answer[i];
            r = r * nums[i]; 
        }

        return answer;
    }
}  
