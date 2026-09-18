class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0;i <= m;i++)
        {
            dp[i][0] = i;
        }
        for(int j = 0;j <= n;j++)
        {
            dp[0][j] = j;
        }

        for(int i = 1;i <= m;i++)
        {
            for(int j = 1;j <= n;j++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                    Math.min(dp[i][j - 1],dp[i - 1][j - 1]));
                }
            }
        }

        return dp[m][n];

        //Memoziation - TC - O(m * n) and SC - O(m * n) and O(m + n)
        // for(int i = 0;i <= m;i++)
        // {
        //     for(int j = 0;j <= n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(m,n,word1,word2,dp);

        // Recursion - TC - O(exponential) and SC - O(m + n)
        // return f(m,n,word1,word2);
    }

    public int fMemoi(int i,int j,String str1,String str2,int[][] dp)
    {
        if(i == 0)
        {
            return j;
        }
        if(j == 0)
        {
            return i;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        if(str1.charAt(i - 1) == str2.charAt(j - 1))
        {
            return dp[i][j] = fMemoi(i - 1,j - 1,str1,str2,dp);
        }
        return dp[i][j] = 1 + Math.min(fMemoi(i - 1,j,str1,str2,dp),
        Math.min(fMemoi(i,j - 1,str1,str2,dp),fMemoi(i - 1,j - 1,str1,str2,dp)));
    }

    public int f(int i,int j,String str1,String str2)
    {
        if(i == 0)
        {
            return j;
        }
        if(j == 0)
        {
            return i;
        }
        if(str1.charAt(i - 1) == str2.charAt(j - 1))
        {
            return f(i - 1,j - 1,str1,str2);
        }
        return 1 + Math.min(f(i - 1,j,str1,str2),Math.min(f(i,j - 1,str1,str2),
        f(i - 1,j - 1,str1,str2)));
    }
}