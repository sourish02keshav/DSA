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

        return uniquePathsMemoization(m,n,m - 1,n - 1,dp);

        // Recursion
        //return uniquePathsHelper(m,n,m - 1,n - 1);
    }

    public int uniquePathsMemoization(int m,int n,int i,int j,int[][] dp)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }
        if(i == 0 && j == 0)
        {
            return 1;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        return dp[i][j] = uniquePathsMemoization(m,n,i - 1,j,dp) + 
        uniquePathsMemoization(m,n,i,j - 1,dp);
    }

    public int uniquePathsHelper(int m,int n,int i,int j)
    {
        if(i < 0 || j < 0)
        {
            return 0;
        }
        if(i == 0 && j == 0)
        {
            return 1;
        }
        return uniquePathsHelper(m,n,i - 1,j) + uniquePathsHelper(m,n,i,j - 1);
    }
}