class Solution {
     public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length-1);
    }

    private int bs(int[] nums, int target, int start, int end) {
        if (start>end) return -1;
        if (start == end){
            if(nums[start]== target) return start;
            else return -1;
        }
        int middle = start + ((end-start)/2);
        if (nums[middle]==target) return middle;
        if (nums[middle]< target) return bs(nums, target, middle+1, end);
        else return bs(nums, target, start, middle-1);
    }
}
