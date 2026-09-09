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

        // Memoization

        for(int i = 0;i <= m;i++)
        {
            for(int j = 0;j <= n;j++)
            {
                dp[i][j] = -1;
            }
        }
        return fMemoi(m,n,text1,text2,dp);

        // Recursion
        // return f(m,n,text1,text2);
    }
}