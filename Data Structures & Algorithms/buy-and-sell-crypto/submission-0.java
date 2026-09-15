class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // We found a new lowest price to buy at
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                // Selling today yields a better profit than before
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}
