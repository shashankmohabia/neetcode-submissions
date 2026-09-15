class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> v = new HashSet<Integer>();
        for (int num: nums) {
            if(!v.add(num)){
                return true;
            }
        }
        return false;
    }
}