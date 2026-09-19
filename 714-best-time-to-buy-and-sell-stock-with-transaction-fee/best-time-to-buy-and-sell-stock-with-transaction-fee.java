class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        // Space Optimization
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int idx = n - 1;idx >= 0;idx--)
        {
            curr[1] = Math.max(-prices[idx] + ahead[0],ahead[1]);
            curr[0] = Math.max(prices[idx] - fee + ahead[1],ahead[0]);
            ahead = curr;
        }
        return ahead[1];

        // Tabulation
        // for(int idx = n - 1;idx >= 0;idx--)
        // {
        //     dp[idx][1] = Math.max(-prices[idx] + dp[idx + 1][0],dp[idx + 1][1]);
        //     dp[idx][0] = Math.max(prices[idx] - fee + dp[idx + 1][1],dp[idx + 1][0]);
        // }
        // return dp[0][1];

        // Memoization
        // for(int i = 0;i <= n;i++)
        // {
        //     for(int j = 0;j <= 1;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(0,1,fee,n,prices,dp);

        // Recursion
        // return f(0,1,fee,n,prices);
    }

    public int fMemoi(int idx,int buy,int fee,int n,int[] prices,int[][] dp)
    {
        if(idx == n)
        {
            return 0;
        }
        if(dp[idx][buy] != -1)
        {
            return dp[idx][buy];
        }
        if(buy == 1)
        {
            return dp[idx][buy] = Math.max(-prices[idx] + fMemoi(idx + 1,0,fee,n,prices,dp),
            fMemoi(idx + 1,1,fee,n,prices,dp));
        }
        return dp[idx][buy] = Math.max(prices[idx] - fee + fMemoi(idx + 1,1,fee,n,prices,dp),
        fMemoi(idx + 1,0,fee,n,prices,dp));
    }

    public int f(int idx,int buy,int fee,int n,int[] prices)
    {
        if(idx == n)
        {
            return 0;
        }
        if(buy == 1)
        {
            return Math.max(-prices[idx] + f(idx + 1,0,fee,n,prices),
            f(idx + 1,1,fee,n,prices));
        }
        return Math.max(prices[idx] - fee + f(idx + 1,1,fee,n,prices),
        f(idx + 1,0,fee,n,prices));
    }
}