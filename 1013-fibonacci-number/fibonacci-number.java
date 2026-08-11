class Solution {
    public int fib(int n) {

        // Recursion
        // if(n <= 1)
        // {
        //     return n;
        // }
        // return fib(n - 1) + fib(n - 2);

        // Memoization

        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return fibHelper(n,dp);
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