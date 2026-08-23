class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];

        for(int j = 0;j < m;j++)
        {
            dp[m - 1][j] = triangle.get(m - 1).get(j);
        }

        for(int i = m - 2;i >= 0;i--)
        {
            for(int j = i;j >= 0;j--)
            {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j],dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];

        // Memoization

        // for(int i = 0;i < m;i++)
        // {
        //     for(int j = 0;j < m;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }

        // return minTotalMemoization(triangle,dp,m,0,0);

        // Recursion
        // return minTotalHelper(triangle,m,0,0);
    }

    public int minTotalMemoization(List<List<Integer>> list,int[][] dp,int m,int i,int j)
    {
        if(i == m - 1)
        {
            return list.get(i).get(j);
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int left = list.get(i).get(j) +  minTotalMemoization(list,dp,m,i + 1,j);
        int right = list.get(i).get(j) + minTotalMemoization(list,dp,m,i + 1,j + 1);
        return dp[i][j] = Math.min(left,right);
    }

    public int minTotalHelper(List<List<Integer>> list,int m,int i,int j)
    {
        if(i == m - 1)
        {
            return list.get(i).get(j);
        }
        int left = list.get(i).get(j) + minTotalHelper(list,m,i + 1,j);
        int right = list.get(i).get(j) + minTotalHelper(list,m,i + 1,j + 1);
        return Math.min(left,right);
    }
}