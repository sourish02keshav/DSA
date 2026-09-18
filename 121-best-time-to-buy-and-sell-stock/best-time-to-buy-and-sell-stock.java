class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1;i < prices.length;i++)
        {
            int cost = prices[i] - buyPrice;
            maxProfit = maxProfit > cost ? maxProfit : cost;
            buyPrice = buyPrice < prices[i] ? buyPrice : prices[i];
        }
        return maxProfit;
    }
}