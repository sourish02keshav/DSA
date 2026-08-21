class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Memoization
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++)
        {
            for(int j = 0;j < n;j++)
            {
                dp[i][j] = -1;
            }
        }

        return minPathSumMemoization(grid,m - 1,n - 1,dp);

        // Recursion
        //return minPathSumHelper(grid,m - 1,n - 1);
    }

    public int minPathSumMemoization(int[][] grid,int i,int j,int[][] dp)
    {
        if(i == 0 && j == 0)
        {
            return grid[i][j];
        }
        if(i < 0 || j < 0)
        {
            return 1000000;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int up = grid[i][j] + minPathSumMemoization(grid,i - 1,j,dp);
        int left = grid[i][j] +  minPathSumMemoization(grid,i,j - 1,dp);
        return dp[i][j] = Math.min(up,left);
    }

    public int minPathSumHelper(int[][] grid,int i,int j)
    {
        if(i == 0 && j == 0)
        {
            return grid[i][j];
        }
        if(i < 0 || j < 0)
        {
            return 1000000;
        }
        int up = grid[i][j] +  minPathSumHelper(grid,i - 1, j);
        int left = grid[i][j] +  minPathSumHelper(grid,i,j - 1);
        return Math.min(up,left);
    }
}