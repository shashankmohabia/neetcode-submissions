class Solution {
    public int[] productExceptSelf(int[] nums) {
        int s = nums.length;
        int[] answer = new int[s];
        int l = 1;
        for (int i = 0; i < s - 1; i++){
            answer[i] = l * nums[i];
            l = answer[i];
        }
        
        answer[s-1] = answer[s-2];
        int r = nums[s-1];

        for (int i = s-2; i>0 ; i--)
        {
            answer[i] = r * answer[i-1];
            r = r * nums[i]; 
        }

        answer[0] = r;

        return answer;
    }
}  
