class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int l = 0, r = 1;
        while(r < prices.length){
            if(prices[r] < prices[l]){
                l = r;
            }
            profit = Math.max(profit, prices[r] - prices[l]);
            r += 1;
        }
        return profit;
    }
}
