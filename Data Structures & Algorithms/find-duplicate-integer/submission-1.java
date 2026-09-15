class Solution {
    public int findDuplicate(int[] nums) {
         int slow = nums[0];
        int fast = nums[0];
        do {// very important to use do-while here, normal while wont work
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
