class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        // Variable Solution - TC - O(n) and SC - O(4)
        int aheadBuy = 0,aheadNotBuy = 0,currBuy = 0,currNotBuy = 0;
        for(int idx = n - 1;idx >= 0;idx--)
        {
            currNotBuy = Math.max(prices[idx] + aheadBuy,aheadNotBuy);
            currBuy = Math.max(-prices[idx] + aheadNotBuy,aheadBuy);
            aheadNotBuy = currNotBuy;
            aheadBuy = currBuy;
        }
        return currBuy;

        // Space Optimization - TC - O(n * 2) and SC - O(4)
        // int[] ahead = new int[2];
        // int[] curr = new int[2];
        // ahead[0] = ahead[1] = 0;
        // for(int idx = n - 1;idx >= 0;idx--)
        // {
        //     for(int buy = 0;buy < 2;buy++)
        //     {
        //         if(buy == 1)
        //         {
        //             curr[1] = Math.max(-prices[idx] + ahead[0],ahead[1]);
        //         }
        //         else
        //         {
        //             curr[0] = Math.max(prices[idx] + ahead[1],ahead[0]);
        //         }
        //     }
        //     ahead = curr;
        // }
        // return curr[1];

        // Tabulation - TC - O(n * 2) and SC - O(n * 2)
        // dp[n][0] = dp[n][1] = 0;
        // for(int idx = n - 1;idx >= 0;idx--)
        // {
        //     for(int buy = 0;buy < 2;buy++)
        //     {
        //         if(buy == 1)
        //         {
        //             dp[idx][1] = Math.max(-prices[idx] + dp[idx + 1][0],dp[idx + 1][1]);
        //         }
        //         else
        //         {
        //             dp[idx][0] = Math.max(prices[idx] + dp[idx + 1][1],dp[idx + 1][0]);
        //         }
        //     }
        // }
        // return dp[0][1];

        // Memoization - TC - O(n * 2) and SC - O(n * 2) + O(n)
        // int b = 1;
        // for(int i = 0;i <= n;i++)
        // {
        //     for(int j = 0;j < 2;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(0,n,b,prices,dp);

        // Recursion - TC - O(2 ^ n) and SC - O(n)
        // boolean buy = true;
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