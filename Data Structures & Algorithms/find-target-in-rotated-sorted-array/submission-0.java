class Solution {

    private int find(int[] nums, int s, int e, int t) {
        if (s > e) return -1;
        if (s == e && nums[s] == t) return s;
        int m = s + (e-s)/2; 
        if (nums[m] == t) return m;
        if (nums[s] <= nums[m]) {
            if (t <= nums[m] && t >= nums[s]) {
                return find(nums, s, m-1, t);
            }
            return find(nums, m+1, e, t);
        } else {
            if (t >= nums[m] && t <= nums[e]) {
                return find(nums, m+1, e, t);
            }
            return find(nums, s, m-1, t);
        }
    }

    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }
}
