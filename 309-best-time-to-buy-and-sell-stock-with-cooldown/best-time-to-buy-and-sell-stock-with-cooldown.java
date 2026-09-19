class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for(int i = 0;i <= n;i++)
        {
            for(int j = 0;j <= 1;j++)
            {
                dp[i][j] = -1;
            }
        }
        return fMemoi(0,1,n,prices,dp);

        // Recursion
        // return f(0,1,n,prices);
    }

    public int fMemoi(int idx,int buy,int n,int[] prices,int[][] dp)
    {
        if(idx >= n)
        {
            return 0;
        }
        if(dp[idx][buy] != -1)
        {
            return dp[idx][buy];
        }
        if(buy == 1)
        {
            return dp[idx][buy] = Math.max(-prices[idx] + fMemoi(idx + 1,0,n,prices,dp),
            fMemoi(idx + 1,buy,n,prices,dp));
        }
        else
        {
            return dp[idx][buy] = Math.max(prices[idx] + fMemoi(idx + 2,1,n,prices,dp),
            fMemoi(idx + 1,buy,n,prices,dp));
        }
    }

    public int f(int idx,int buy,int n,int[] prices)
    {
        if(idx >= n)
        {
            return 0;
        }
        if(buy == 1)
        {
            return Math.max(-prices[idx] + f(idx + 1,0,n,prices),
            f(idx + 1,buy,n,prices));
        }
        else
        {
            return Math.max(prices[idx] + f(idx + 2,1,n,prices),
            f(idx + 1,buy,n,prices));
        }
    }
}