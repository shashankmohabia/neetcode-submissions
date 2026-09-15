class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> r = new HashMap<Integer, Integer>();
        for (int i=0;i< nums.length;i++) {
            int c = nums[i];
            if(r.containsKey(c)){
                return new int[]{r.get(c), i};
            } else {
                r.put(target-c, i);
            }
        }
        return new int[]{0};
    }
}
