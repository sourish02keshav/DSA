class Solution {
    public int climbStairs(int n) {

        // Recursion

        // if(n <= 1)
        // {
        //     return 1;
        // }
        // return climbStairs(n - 1) + climbStairs(n - 2);

        // Memoization

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp,-1);
        // return climbStairsHelper(n,dp);

        // Tabulation

        // int[] dp = new int[n + 1];
        // dp[0] = 1;
        // dp[1] = 1;
        // for(int i = 2;i <= n;i++)
        // {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];

        // Optimal Approach : TC - O(n) and SC - O(n)

        int prev = 1;
        int prev2 = prev;

        for(int i = 2;i <= n;i++)
        {
            int currSum = prev + prev2;
            prev2 = prev;
            prev = currSum;
        }
        return prev;
    }

    public int climbStairsHelper(int n,int[] dp)
    {
        if(n <= 1)
        {
            return 1;
        }
        if(dp[n] != -1)
        {
            return dp[n];
        }
        return dp[n] = climbStairsHelper(n - 1,dp) + climbStairsHelper(n - 2,dp);
    }
}