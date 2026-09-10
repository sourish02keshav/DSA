class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Space optimization

        int[] prev = new int[n + 1];

        for(int i = 1;i <= m;i++)
        {
            int[] curr = new int[n + 1];
            for(int j = 1;j <= n;j++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
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

        int lcs = prev[n];

        // Tabulation

        // for(int i = 1;i <= m;i++)
        // {
        //     for(int j = 1;j <= n;j++)
        //     {
        //         if(word1.charAt(i - 1) == word2.charAt(j - 1))
        //         {
        //             dp[i][j] = 1 + dp[i - 1][j - 1];
        //         }
        //         else
        //         {
        //             dp[i][j] = Math.max(dp[i - 1][j],dp[i][j -1]);
        //         }
        //     }
        // }
        // int lcs = dp[m][n];

        // Memoization

        // for(int i = 0;i <= m;i++)
        // {
        //     for(int j = 0;j <= n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // int lcs = fMemoi(m,n,word1,word2,dp);

        // Recursion
        // int lcs = f(m,n,word1,word2);
        return m + n - (2 * lcs);
    }

    public int fMemoi(int idx1,int idx2,String word1,String word2,int[][] dp)
    {
        if(idx1 == 0 || idx2 == 0)
        {
            return 0;
        }
        if(dp[idx1][idx2] != -1)
        {
            return dp[idx1][idx2];
        }
        if(word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1))
        {
            return dp[idx1][idx2] = 1 + fMemoi(idx1 - 1,idx2 - 1,word1,word2,dp);
        }
        return dp[idx1][idx2] = Math.max(fMemoi(idx1 - 1,idx2,word1,word2,dp),
        fMemoi(idx1,idx2 - 1,word1,word2,dp));
    }

    public int f(int idx1,int idx2,String word1,String word2)
    {
        if(idx1 == 0 || idx2 == 0)
        {
            return 0;
        }
        if(word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1))
        {
            return 1 + f(idx1 - 1,idx2 - 1,word1,word2);
        }
        return Math.max(f(idx1 - 1,idx2,word1,word2),f(idx1,idx2 - 1,word1,word2));
    }
}