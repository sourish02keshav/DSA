class Solution {
    public int rob(int[] nums) {

        // TC - O(n) and SC - O(1) approach

        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1;i < n;i++)
        {
            int take = nums[i] + prev2;
            int notTake = prev;
            int currSum = Math.max(take,notTake);
            prev2 = prev;
            prev = currSum;
        }

        return prev;

        // Tabulation

        // int n = nums.length;
        // int[] dp = new int[n];
        // dp[0] = nums[0];

        // for(int i = 1;i < n;i++)
        // {
        //     int take = nums[i];
        //     if(i > 1)
        //     {
        //         take += dp[i - 2];
        //     }
        //     int notTake = dp[i - 1];
        //     dp[i] = Math.max(take,notTake);
        // }
        // return dp[n - 1];

        // Memoization

        // int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        // return robMemoization(n - 1,nums,dp);

        // Recursion
        // return robHelper(nums.length - 1,nums);
    }

    public int robMemoization(int n,int[] arr,int[] dp)
    {
        if(n == 0)
        {
            return arr[n];
        }
        if(n < 0)
        {
            return 0;
        }
        if(dp[n] != -1)
        {
            return dp[n];
        }
        int take = arr[n] + robMemoization(n - 2,arr,dp);
        int notTake = robMemoization(n - 1,arr,dp);
        return dp[n] = Math.max(take,notTake);
    }

    public int robHelper(int n,int[] arr)
    {
        if(n == 0)
        {
            return arr[0];
        }
        if(n < 0)
        {
            return 0;
        }

        int take = arr[n] + robHelper(n - 2,arr);
        int notTake = robHelper(n - 1,arr);
        return Math.max(take,notTake);
    }
}