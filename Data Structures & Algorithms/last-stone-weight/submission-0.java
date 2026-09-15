class Solution {
    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> maxStones = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int stone:stones) {
            maxStones.offer(stone);
        }
        while (maxStones.size() > 1) {
            int largest = maxStones.poll();
            int sLargest = maxStones.poll();
            if (largest != sLargest) {
                maxStones.offer(largest-sLargest);
            }
        }
        return maxStones.isEmpty()? 0: maxStones.poll();
    }
}
