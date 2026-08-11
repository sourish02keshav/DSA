class Solution {
    public int fib(int n) {

        // Recursion
        // if(n <= 1)
        // {
        //     return n;
        // }
        // return fib(n - 1) + fib(n - 2);

        // Memoization

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp,-1);
        // return fibHelper(n,dp);

        // Tabulation

        // if(n == 0)
        // {
        //     return n;
        // }
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;

        // for(int i = 2;i <= n;i++)
        // {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }

        // return dp[n];

        // TC - O(n) and SC - O(1) approach

        if(n == 0)
        {
            return n;
        }
        int prev = 1;
        int prev2 = 0;

        for(int i = 2;i <= n;i++)
        {
            int currSum = prev + prev2;
            prev2 = prev;
            prev = currSum;
        }

        return prev;
    }

    public int fibHelper(int n,int[] dp)
    {
        if(n <= 1)
        {
            return n;
        }
        if(dp[n] != -1)
        {
            return dp[n];
        }
        return dp[n] = fibHelper(n - 1,dp) + fibHelper(n - 2,dp);
    }
}