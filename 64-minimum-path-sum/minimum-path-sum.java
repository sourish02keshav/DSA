class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Space Optimization

        int[] prev = new int[n];

        for(int i = 0;i < m;i++)
        {
            int[] temp = new int[n];
            for(int j = 0;j < n;j++)
            {
                if(i == 0 && j == 0)
                {
                    temp[j] = grid[i][j];
                }
                else
                {
                    int down = grid[i][j];
                    int right = grid[i][j];
                    if(i > 0)
                    {
                        down += prev[j];
                    }
                    else
                    {
                        down += 100000;
                    }
                    if(j > 0)
                    {
                        right += temp[j - 1];
                    }
                    else
                    {
                        right += 100000;
                    }
                    temp[j] = Math.min(down,right);
                }
            }
            prev = temp;
        }
        return prev[n - 1];

        // Tabulation

        // int[][] dp = new int[m][n];
        // for(int i = 0;i < m;i++)
        // {
        //     for(int j = 0;j < n;j++)
        //     {
        //         if(i == 0 && j == 0)
        //         {
        //             dp[i][j] = grid[i][j];
        //         }
        //         else
        //         {
        //             int down = grid[i][j];
        //             int right = grid[i][j];
        //             if(i > 0)
        //             {
        //                 down += dp[i - 1][j];
        //             }
        //             else
        //             {
        //                 down += 1000000;
        //             }
        //             if(j > 0)
        //             {
        //                 right += dp[i][j - 1];
        //             }
        //             else
        //             {
        //                 right += 1000000;
        //             }
        //             dp[i][j] = Math.min(down,right);
        //         }
        //     }
        // }
        // return dp[m - 1][n - 1];

        // Memoization
        // int[][] dp = new int[m][n];
        // for(int i = 0;i < m;i++)
        // {
        //     for(int j = 0;j < n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }

        // return minPathSumMemoization(grid,m - 1,n - 1,dp);

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