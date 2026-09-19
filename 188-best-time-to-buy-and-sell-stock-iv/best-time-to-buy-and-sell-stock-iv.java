class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        // Tabulation
        for(int idx = n - 1;idx >= 0;idx--)
        {
            for(int buy = 0;buy <= 1;buy++)
            {
                for(int cap = 1;cap <= k;cap++)
                {
                    if(buy == 1)
                    {
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][0][cap],
                        dp[idx + 1][buy][cap]);
                    }
                    else
                    {
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][1][cap - 1],
                        dp[idx + 1][buy][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];

        // Memoization
        // for(int i = 0;i <= n;i++)
        // {
        //     for(int j = 0;j <= 1;j++)
        //     {
        //         for(int cap = 0;cap <= k;cap++)
        //         {
        //             dp[i][j][cap] = -1;
        //         }
        //     }
        // }
        // return fMemoi(0,1,k,n,prices,dp);

        // Recursion
        // return f(0,1,k,n,prices);
    }

    public int fMemoi(int idx,int buy,int cap,int n,int[] prices,int[][][] dp)
    {
        if(idx == n || cap == 0)
        {
            return 0;
        }
        if(dp[idx][buy][cap] != -1)
        {
            return dp[idx][buy][cap];
        }
        if(buy == 1)
        {
            dp[idx][buy][cap] = Math.max(-prices[idx] + fMemoi(idx + 1,0,cap,n,prices,dp),
            fMemoi(idx + 1,buy,cap,n,prices,dp));
        }
        else
        {
            dp[idx][buy][cap] = Math.max(prices[idx] + fMemoi(idx + 1,1,cap - 1,n,prices,dp),
            fMemoi(idx + 1,buy,cap,n,prices,dp));
        }
        return dp[idx][buy][cap];
    }

    public int f(int idx,int buy,int cap,int n,int[] prices)
    {
        if(idx == n || cap == 0)
        {
            return 0;
        }
        int profit = 0;
        if(buy == 1)
        {
            profit = Math.max(-prices[idx] + f(idx + 1,0,cap,n,prices),
            f(idx + 1,buy,cap,n,prices));
        }
        else
        {
            profit = Math.max(prices[idx] + f(idx + 1,1,cap - 1,n,prices),
            f(idx + 1,buy,cap,n,prices));
        }
        return profit;
    }
}