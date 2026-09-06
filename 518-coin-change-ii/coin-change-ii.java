class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Tabulation

        for(int j = 0;j <= amount;j++)
        {
            if(j % coins[0] == 0)
            {
                dp[0][j] = 1;
            }
        }
        for(int idx = 1;idx < n;idx++)
        {
            for(int j = 0;j <= amount;j++)
            {
                int notTake = dp[idx - 1][j];
                int take = 0;
                if(coins[idx] <= j)
                {
                    take = dp[idx][j - coins[idx]];
                }
                dp[idx][j] = take + notTake;
            }
        }
        return dp[n - 1][amount];

        // Memoization

        // for(int i = 0;i < n;i++)
        // {
        //     for(int j = 0;j <= amount;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }

        // return fMemoi(n - 1,amount,coins,dp);

        // Recursion
        // return f(n - 1,amount,coins);
    }

    public int fMemoi(int idx,int amount,int[] coins,int[][] dp)
    {
        if(idx == 0)
        {
            if(amount % coins[idx] == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(dp[idx][amount] != -1)
        {
            return dp[idx][amount];
        }
        int notTake = fMemoi(idx - 1,amount,coins,dp);
        int take = 0;
        if(coins[idx] <= amount)
        {
            take = fMemoi(idx,amount - coins[idx],coins,dp);
        }
        return dp[idx][amount] = take + notTake;
    }

    public int f(int idx,int amount,int[] coins)
    {
        if(idx == 0)
        {
            if(amount % coins[idx] == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        int notTake = f(idx - 1,amount,coins);
        int take = 0;
        if(coins[idx] <= amount)
        {
            take = f(idx,amount - coins[idx],coins);
        }
        return take + notTake;
    }
}