class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Memoization

        for(int i = 0;i <= m;i++)
        {
            for(int j = 0;j <= n;j++)
            {
                dp[i][j] = -1;
            }
        }
        int lcs = fMemoi(m,n,word1,word2,dp);

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