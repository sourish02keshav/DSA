class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();

        // Space Optimization

        List<Integer> next = new ArrayList<>();
        for(int i = m - 1;i >= 0;i--)
        {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0;j < triangle.get(i).size();j++)
            {
                temp.add(0);
            }
            for(int j = triangle.get(i).size() - 1;j >= 0;j--)
            {
                if(i == m - 1)
                {
                    temp.set(j,triangle.get(i).get(j));
                }
                else
                {
                    int left = triangle.get(i).get(j) + next.get(j);
                    int right = triangle.get(i).get(j) + next.get(j + 1);
                    temp.set(j,Math.min(left,right));
                }
            }
            next = temp;
        }

        return next.get(0);


        // Tabulation

        // for(int i = 0;i < triangle.size();i++)
        // {
        //     dp.add(new ArrayList<>());
        //     for(int j = 0;j < triangle.get(i).size();j++)
        //     {
        //         dp.get(i).add(0);
        //     }
        // }

        // for(int i = m - 1;i >= 0;i--)
        // {
        //     for(int j = triangle.get(i).size() - 1;j >= 0;j--)
        //     {
        //         if(i == m - 1)
        //         {
        //             dp.get(i).set(j,triangle.get(i).get(j));
        //         }
        //         else
        //         {
        //             int left = triangle.get(i).get(j) + dp.get(i + 1).get(j);
        //             int right = triangle.get(i).get(j) + dp.get(i + 1).get(j + 1);
        //             dp.get(i).set(j,Math.min(left,right));
        //         }
        //     }
        // }
        // return dp.get(0).get(0);

        // Memoization

        // for(int i = 0;i < m;i++)
        // {
        //     dp.add(new ArrayList<>());
        //     for(int j = 0;j < triangle.get(i).size();j++)
        //     {
        //         dp.get(i).add(-1);
        //     }
        // }

        // return minTotalMemoization(triangle,dp,m,0,0);

        // Recursion
        // return minimumTotalHelper(triangle,m,0,0);
    }

    public int minTotalMemoization(List<List<Integer>> list,List<List<Integer>> dp,int m,int i,int j)
    {
        if(i == m - 1)
        {
            return list.get(i).get(j);
        }
        if(dp.get(i).get(j) != -1)
        {
            return dp.get(i).get(j);
        }
        int left = list.get(i).get(j) +  minTotalMemoization(list,dp,m,i + 1,j);
        int right = list.get(i).get(j) + minTotalMemoization(list,dp,m,i + 1,j + 1);
        int ans = Math.min(left,right);
        dp.get(i).set(j,ans);
        return ans;
    }

    public int minimumTotalHelper(List<List<Integer>> list,int m,int i,int j)
    {
        if(i == m - 1)
        {
            return list.get(i).get(j);
        }
        int left = list.get(i).get(j) +  minimumTotalHelper(list,m,i + 1,j);
        int right = list.get(i).get(j) + minimumTotalHelper(list,m,i + 1,j + 1);
        return Math.min(left,right);
    }
}