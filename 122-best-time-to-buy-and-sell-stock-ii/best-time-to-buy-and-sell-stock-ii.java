class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        boolean buy = true;
        int[][] dp = new int[n + 1][2];

        // Memoization
        int b = 1;
        for(int i = 0;i <= n;i++)
        {
            for(int j = 0;j < 2;j++)
            {
                dp[i][j] = -1;
            }
        }
        return fMemoi(0,n,b,prices,dp);

        // Recursion
        // return f(0,n,buy,prices);
    }

    public int fMemoi(int idx,int n,int buy,int[] prices,int[][] dp)
    {
        if(idx == n)
        {
            return 0;
        }
        if(dp[idx][buy] != -1)
        {
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1)
        {
            profit = Math.max(-prices[idx] + fMemoi(idx + 1,n,0,prices,dp),
            fMemoi(idx + 1,n,buy,prices,dp));
        }
        else
        {
            profit = Math.max(prices[idx] + fMemoi(idx + 1,n,1,prices,dp),
            fMemoi(idx + 1,n,buy,prices,dp));
        }
        return dp[idx][buy] = profit;
    }

    public int f(int idx,int n,boolean buy,int[] prices)
    {
        if(idx == n)
        {
            return 0;
        }
        int profit = 0;
        if(buy)
        {
            profit = Math.max(-prices[idx] + f(idx + 1,n,false,prices),
            f(idx + 1,n,buy,prices));
        }
        else
        {
            profit = Math.max(prices[idx] + f(idx + 1,n,true,prices),
            f(idx + 1,n,buy,prices));
        }
        return profit;
    }
}