class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][n];

        for(int j1 = 0;j1 < n;j1++)
        {
            for(int j2 = 0;j2 < n;j2++)
            {
                if(j1 == j2)
                {
                    dp[m - 1][j1][j2] = grid[m - 1][j1];
                }
                else
                {
                    dp[m - 1][j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        for(int i = m - 2;i >= 0;i--)
        {
            for(int j1 = 0;j1 < n;j1++)
            {
                for(int j2 = 0;j2 < n;j2++)
                {
                    int max = -100000;
                    for(int dir1 = -1;dir1 <= 1;dir1++)
                    {
                        for(int dir2 = -1;dir2 <= 1;dir2++)
                        {
                            int value = 0;
                            if(j1 == j2)
                            {
                                value += grid[i][j1];
                            }
                            else
                            {
                                value += grid[i][j1] + grid[i][j2];
                            }
                            if(j1 + dir1 >= 0 && j1 + dir1 < n && j2 + dir2 >= 0 && j2 + dir2 < n)
                            {
                                value += dp[i + 1][j1 + dir1][j2 + dir2];
                            }
                            else
                            {
                                value = -10000;
                            }
                            max = Math.max(max,value);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }

        return dp[0][0][n - 1];
        // Memoi

        // for(int i = 0;i < m;i++)
        // {
        //     for(int j = 0;j < n;j++)
        //     {
        //         for(int k = 0;k < n;k++)
        //         {
        //             dp[i][j][k] = -1;
        //         }
        //     }
        // }

        // return fMemoi(grid,0,0,n - 1,m,n,dp);

        // Recursion
        // return f(grid,0,0,n - 1,m,n);
    }

    public int fMemoi(int[][] grid,int i,int j1,int j2,int m,int n,int[][][] dp)
    {
        if(j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
        {
            return -10000;
        }
        if(i == m - 1)
        {
            if(j1 == j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1)
        {
            return dp[i][j1][j2];
        }
        int max = -10000;
        for(int dir1 = -1;dir1 <= 1;dir1++)
        {
            for(int dir2 = -1;dir2 <= 1;dir2++)
            {
                int value = 0;
                if(j1 == j2)
                {
                    value += grid[i][j1];
                }
                else
                {
                    value += grid[i][j1] + grid[i][j2];
                }
                max = Math.max(max,value + fMemoi(grid,i + 1,j1 + dir1,j2 + dir2,m,n,dp));
            }
        }
        return dp[i][j1][j2] = max;
    }

    public int f(int[][] grid,int i,int j1,int j2,int m,int n)
    {
        if(j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
        {
            return -10000;
        }
        if(i == m - 1)
        {
            if(j1 == j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        int max = -10000;
        for(int dir1 = -1;dir1 <= 1;dir1++)
        {
            for(int dir2 = -1;dir2 <= 1;dir2++)
            {
                int value = 0;
                if(j1 == j2)
                {
                    value += grid[i][j1];
                }
                else
                {
                    value += grid[i][j1] + grid[i][j2];
                }
                max = Math.max(max,value + f(grid,i + 1,j1 + dir1,j2 + dir2,m,n));
            }
        }
        return max;
    }
}