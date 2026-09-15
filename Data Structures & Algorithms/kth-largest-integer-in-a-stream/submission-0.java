class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    int km;

    public KthLargest(int k, int[] nums) {
        km = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(heap.size() < km){
            heap.offer(val);
            return heap.peek();
        }
        int kmax = heap.peek();
        if (kmax < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
