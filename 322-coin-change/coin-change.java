class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        // Memoization

        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j <= amount;j++)
            {
                dp[i][j] = -1;
            }
        }

        int ans = fMemoi(n - 1,amount,coins,dp);

        // Recursion
        // int ans = f(n - 1,coins,amount);

        if(ans >= 1e7)
        {
            return -1;
        }
        return ans;
    }

    public int fMemoi(int idx,int amount,int[] coins,int[][] dp)
    {
        if(idx == 0)
        {
            if(amount % coins[idx] == 0)
            {
                return amount / coins[idx];
            }
            else
            {
                return Integer.MAX_VALUE;
            }
        }
        if(dp[idx][amount] != -1)
        {
            return dp[idx][amount];
        }

        int notTake = fMemoi(idx - 1,amount,coins,dp);
        int take = (int)1e9;
        if(coins[idx] <= amount)
        {
            take = 1 + fMemoi(idx,amount - coins[idx],coins,dp);
        }
        return dp[idx][amount] = Math.min(take,notTake);
    }

    public int f(int idx,int[] coins,int amount)
    {
        if(idx == 0)
        {
            if(amount % coins[idx] == 0)
            {
                return amount / coins[idx];
            }
            else
            {
                return Integer.MAX_VALUE;
            }
        }
        int notTake = f(idx - 1,coins,amount);
        int take = (int)1e7;
        if(coins[idx] <= amount)
        {
            take = 1 + f(idx,coins,amount - coins[idx]);
        }
        return Math.min(take,notTake);
    }
}