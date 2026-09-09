class Solution {

    public int fMemoi(int idx1,int idx2,String text1,String text2,int[][] dp)
    {
        if(idx1 == 0 || idx2 == 0)
        {
            return 0;
        }
        if(dp[idx1][idx2] != -1)
        {
            return dp[idx1][idx2];
        }
        if(text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1))
        {
            return dp[idx1][idx2] = 1 + fMemoi(idx1 - 1,idx2 - 1,text1,text2,dp);
        }
        return dp[idx1][idx2] = Math.max(fMemoi(idx1 - 1,idx2,text1,text2,dp), fMemoi(idx1,idx2 - 1,text1,text2,dp));
    }

    public int f(int idx1,int idx2,String text1,String text2)
    {
        if(idx1 == 0 || idx2 == 0)
        {
            return 0;
        }
        if(text1.charAt(idx1 - 1) == text2.charAt(idx2 - 1))
        {
            return 1 + f(idx1 - 1,idx2 - 1,text1,text2);
        }
        return Math.max(f(idx1 - 1,idx2,text1,text2),f(idx1,idx2 - 1,text1,text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Space optimization

        int[] prev = new int[n + 1];
        for(int i = 0;i <= n;i++)
        {
            prev[i] = 0;
        }
        for(int i = 1;i <= m;i++)
        {
            int[] curr = new int[n + 1];
            for(int j = 1;j <= n;j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                {
                    curr[j] = 1 + prev[j - 1];
                }
                else
                {
                    curr[j] = Math.max(prev[j],curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[n];

        // Tabulation

        // for(int i = 0;i <= m;i++)
        // {
        //     dp[i][0] = 0;
        // }
        // for(int j = 0;j <= n;j++)
        // {
        //     dp[0][j] = 0;
        // }
        // for(int i = 1;i <= m;i++)
        // {
        //     for(int j = 1;j <= n;j++)
        //     {
        //         if(text1.charAt(i - 1) == text2.charAt(j - 1))
        //         {
        //             dp[i][j] = 1 + dp[i - 1][j - 1];
        //         }
        //         else
        //         {
        //             dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
        //         }
        //     }
        // }
        // return dp[m][n];

        // Memoization

        // for(int i = 0;i <= m;i++)
        // {
        //     for(int j = 0;j <= n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(m,n,text1,text2,dp);

        // Recursion
        // return f(m,n,text1,text2);
    }
}