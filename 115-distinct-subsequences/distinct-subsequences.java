class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        // Tabulation

        for(int i = 0;i <= m;i++)
        {
            dp[i][0] = 1;
        }
        for(int j = 1;j <= n;j++)
        {
            dp[0][j] = 0;
        }

        for(int i = 1;i <= m;i++)
        {
            for(int j = 1;j <= n;j++)
            {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];

        // Memoization - TC - O(m * n) and SC - O(m * n) and O(m + n)
        // for(int i = 0;i <= m;i++)
        // {
        //     for(int j = 0;j <= n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(m,n,s,t,dp);

        // Recursion - TC - O((2 ^ n) * (2 ^ m)) approx O(exponentail) and SC - O(m + n)
        // return f(m,n,s,t);
    }

    public int fMemoi(int i,int j,String s,String t,int[][] dp)
    {
        if(j == 0)
        {
            return 1;
        }
        if(i == 0)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        if(s.charAt(i - 1) == t.charAt(j - 1))
        {
            dp[i][j] = fMemoi(i - 1,j - 1,s,t,dp) + fMemoi(i - 1,j,s,t,dp);
        }
        else
        {
            dp[i][j] = fMemoi(i - 1,j,s,t,dp);
        }
        return dp[i][j];
    }

    public int f(int i,int j,String s,String t)
    {
        if(j == 0)
        {
            return 1;
        }
        if(i == 0)
        {
            return 0;
        }
        if(s.charAt(i - 1) == t.charAt(j - 1))
        {
            return f(i - 1,j - 1,s,t) + f(i - 1,j,s,t);
        }
        else
        {
            return f(i - 1,j,s,t);
        }

    }
}