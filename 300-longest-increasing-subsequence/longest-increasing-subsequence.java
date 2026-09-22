class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // Tabulation
        int[][] dp = new int[n + 1][n + 1];
        for(int idx = n - 1;idx >= 0;idx--)
        {
            for(int prevIdx = idx - 1;prevIdx >= -1;prevIdx--)
            {
                int len = dp[idx + 1][prevIdx + 1];
                if(prevIdx == -1 || nums[idx] > nums[prevIdx])
                {
                    len = Math.max(len,1 + dp[idx + 1][idx + 1]);
                }
                dp[idx][prevIdx + 1] = len;
            }
        }
        return dp[0][-1 + 1];

        // Memoization
        // int[][] dp = new int[n][n + 1];
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

    public int fMemoi(int idx,int prevIdx,int n,int[] arr,int[][] dp)
    {
        if(idx == n)
        {
            return 0;
        }
        if(dp[idx][prevIdx + 1] != -1)
        {
            return dp[idx][prevIdx + 1];
        }
        int len = fMemoi(idx + 1,prevIdx,n,arr,dp);
        if(prevIdx == -1 || arr[idx] > arr[prevIdx])
        {
            len = Math.max(len,1 + fMemoi(idx + 1,idx,n,arr,dp));
        }
        return len;
    }

    public int f(int idx,int prevIdx,int n,int[] arr)
    {
        if(idx == n)
        {
            return 0;
        }
        int len = f(idx + 1,prevIdx,n,arr);
        if(prevIdx == -1 || arr[idx] > arr[prevIdx])
        {
            len = Math.max(len,1 + f(idx + 1,idx,n,arr));
        }
        return len;
    }
}