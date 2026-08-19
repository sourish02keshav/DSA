class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++)
        {
            for(int j = 0;j < n;j++)
            {
                dp[i][j] = -1;
            }
        }
        return uniquePathsHelper(m,n,0,0,dp);
    }
    public int uniquePathsHelper(int m,int n,int i,int j,int[][] dp)
    {
        if(i == m || j == n)
        {
            return 0;
        }
        if(i == m - 1 && j == n - 1)
        {
            return 1;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        return dp[i][j] = uniquePathsHelper(m,n,i,j + 1,dp) + 
        uniquePathsHelper(m,n,i + 1,j,dp);
    }
}