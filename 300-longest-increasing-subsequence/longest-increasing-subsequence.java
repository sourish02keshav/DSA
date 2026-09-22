class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // Alternative Approach - TC - O(n * n) and SC - O(n)
        int[] dp = new int[n];
        int max = 1;
        for(int idx = 0;idx < n;idx++)
        {
            dp[idx] = 1;
            for(int prevIdx = 0;prevIdx < idx;prevIdx++)
            {
                if(nums[idx] > nums[prevIdx])
                {
                    dp[idx] = Math.max(dp[idx],1 + dp[prevIdx]);
                }
            }
            max = Math.max(max,dp[idx]);
        }
        return max;

        // Space Optimization - TC - O(n * n) and SC - 2 * O(n)
        // int[] next = new int[n + 1];
        // int[] curr = new int[n + 1];
        // for(int idx = n - 1;idx >= 0;idx--)
        // {
        //     for(int prevIdx = idx - 1;prevIdx >= -1;prevIdx--)
        //     {
        //         int len = next[prevIdx + 1];
        //         if(prevIdx == -1 || nums[idx] > nums[prevIdx])
        //         {
        //             len = Math.max(len,1 + next[idx + 1]);
        //         }
        //         curr[prevIdx + 1] = len;
        //     }
        //     next = curr;
        // }
        // return next[-1 + 1];

        // Tabulation - TC - O(n * n) and SC - O(n * n)
        // int[][] dp = new int[n + 1][n + 1];
        // for(int idx = n - 1;idx >= 0;idx--)
        // {
        //     for(int prevIdx = idx - 1;prevIdx >= -1;prevIdx--)
        //     {
        //         int len = dp[idx + 1][prevIdx + 1];
        //         if(prevIdx == -1 || nums[idx] > nums[prevIdx])
        //         {
        //             len = Math.max(len,1 + dp[idx + 1][idx + 1]);
        //         }
        //         dp[idx][prevIdx + 1] = len;
        //     }
        // }
        // return dp[0][-1 + 1];

        // Memoization - TC - O(n * n) and SC - O(n * n) and O(n)
        // int[][] dp = new int[n][n + 1];
        // for(int i = 0;i < n;i++)
        // {
        //     for(int j = 0;j <= n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(0,-1,n,nums,dp);

        // Recursion - TC - O(2 ^ n) and SC - O(n)
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
        return dp[idx][prevIdx + 1] = len;
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