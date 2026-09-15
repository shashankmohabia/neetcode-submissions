class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> v = new HashSet<Integer>();
        for (int num: nums) {
            if(v.contains(num) == true){
                return true;
            }
            v.add(num);
        }
        return false;
    }
}