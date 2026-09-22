class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // Memoization - TC - O()
        int[][] dp = new int[n][n + 1];
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j <= n;j++)
            {
                dp[i][j] = -1;
            }
        }
        return fMemoi(0,-1,n,nums,dp);

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