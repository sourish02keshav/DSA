class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        for(int i = 0;i < m;i++)
        {
            int[] temp = new int[n];
            for(int j = 0;j < n;j++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    continue;
                }
                if(i == 0 && j == 0)
                {
                    temp[j] = 1;
                }
                else
                {
                    if(i > 0)
                    {
                        temp[j] += prev[j];
                    }
                    if(j > 0)
                    {
                        temp[j] += temp[j - 1];
                    }
                }
            }
            prev = temp;
        }
        return prev[n - 1];

        // int m = obstacleGrid.length;
        // int n = obstacleGrid[0].length;
        // int[][] dp = new int[m][n];
        // for(int i = 0;i < m;i++)
        // {
        //     for(int j = 0;j < n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return uniquePathsWithObstaclesHelper(obstacleGrid,m,n,m - 1,n - 1,dp);
    }

    public int uniquePathsWithObstaclesHelper(int[][] grid,int m,int n,int i,int j,int[][] dp)
    {
        if(i < 0 || j < 0 || grid[i][j] == 1)
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
        return dp[i][j] = uniquePathsWithObstaclesHelper(grid,m,n,i - 1,j,dp) + 
        uniquePathsWithObstaclesHelper(grid,m,n,i,j - 1,dp);
    }
}