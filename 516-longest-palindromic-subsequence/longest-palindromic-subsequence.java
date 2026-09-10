class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String rev = "";
        for(int i = 0;i < m;i++)
        {
            rev = s.charAt(i) + rev;
        }
        int[][] dp = new int[m + 1][m + 1];

        // Tabulation

        for(int i = 1;i <= m;i++)
        {
            for(int j = 1;j <= m;j++)
            {
                if(s.charAt(i - 1) == rev.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return dp[m][m];

        // Memoization

        // for(int i = 0;i <= m ;i++)
        // {
        //     for(int j = 0;j <= m;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(m,m,s,rev,dp);

        // Recursion
        //return f(m,m,s,rev);
    }

    int fMemoi(int idx1,int idx2,String str1,String str2,int[][] dp)
    {
        if(idx1 == 0 || idx2 == 0)
        {
            return 0;
        }
        if(dp[idx1][idx2] != -1)
        {
            return dp[idx1][idx2];
        }
        if(str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1))
        {
            return dp[idx1][idx2] = 1 + fMemoi(idx1 - 1,idx2 - 1,str1,str2,dp);
        }
        return dp[idx1][idx2] = Math.max(fMemoi(idx1 - 1,idx2,str1,str2,dp),fMemoi(idx1,idx2 - 1,str1,str2,dp));
    }

    int f(int idx1,int idx2,String str1,String str2)
    {
        if(idx1 == 0 || idx2 == 0)
        {
            return 0;
        }
        if(str1.charAt(idx1 - 1) == str2.charAt(idx2 - 1))
        {
            return 1 + f(idx1 - 1,idx2 - 1,str1,str2);
        }
        return Math.max(f(idx1 - 1,idx2,str1,str2),f(idx1,idx2 - 1,str1,str2));
    }
}