class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        // Tabulation

        for(int idx = n - 1;idx >= 0;idx--)
        {
            for(int prev_idx = idx - 1;prev_idx >= -1;prev_idx--)
            {
                int len = dp[idx + 1][prev_idx + 1];
                if(prev_idx == -1 || nums[idx] > nums[prev_idx])
                {
                    len = Math.max(len,1 + dp[idx + 1][idx + 1]);
                }
                dp[idx][prev_idx + 1] = len;
            }
        }
        return dp[0][-1 + 1];

        // Memoization
        // for(int i = 0;i < n;i++)
        // {
        //     for(int j = 0;j <= n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(0,-1,n,nums,dp);

        // Recursion
        // return f(0,-1,n,nums);
    }

    public int fMemoi(int idx,int prev_idx,int n,int[] arr,int[][] dp)
    {
        if(idx == n)
        {
            return 0;
        }
        if(dp[idx][prev_idx + 1] != -1)
        {
            return dp[idx][prev_idx + 1];
        }
        int len = fMemoi(idx + 1,prev_idx,n,arr,dp);
        if(prev_idx == -1 || arr[idx] > arr[prev_idx])
        {
            len = Math.max(len,1 + fMemoi(idx + 1,idx,n,arr,dp));
        }
        return dp[idx][prev_idx + 1] = len;
    }


    public int f(int idx,int prev_idx,int n,int[] arr)
    {
        if(idx == n)
        {
            return 0;
        }
        int len = f(idx + 1,prev_idx,n,arr);
        if(prev_idx == -1 || arr[idx] > arr[prev_idx])
        {
            len = Math.max(len,1 + f(idx + 1,idx,n,arr));
        }
        return len;
    }
}