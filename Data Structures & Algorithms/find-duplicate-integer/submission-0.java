class Solution {
    public int findDuplicate(int[] nums) {
         int i = 0;
        int l = nums.length;
        while (i < l) {
            int index = nums[i];
            int valueAtIndex = nums[index];
            if (valueAtIndex == 0){
                return index;
            } else {
                nums[i] = valueAtIndex;
                nums[index] = 0;
                i--;
            }
            i++;
        }
        return nums[i];
    }
}
