class Solution {

    public int fMemoi(int idx,int sum,int[] arr,int[][] dp)
    {
        if(idx == 0)
        {
            if(arr[idx] == 0 && sum == 0)
            {
                return 2;
            }
            else if(arr[idx] == sum || sum == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(dp[idx][sum] != -1)
        {
            return dp[idx][sum];
        }
        int notTake = fMemoi(idx - 1,sum,arr,dp);
        int take = 0;
        if(arr[idx] <= sum)
        {
            take = fMemoi(idx - 1,sum - arr[idx],arr,dp);
        }
        return dp[idx][sum] = take + notTake;
    }

    public int f(int idx,int sum,int[] arr)
    {
        if(idx == 0)
        {
            if(arr[idx] == 0 && sum == 0)
            {
                return 2;
            }
            else if(arr[idx] == sum || sum == 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        int notTake = f(idx - 1,sum,arr);
        int take = 0;
        if(arr[idx] <= sum)
        {
            take = f(idx - 1,sum - arr[idx],arr);
        }
        return take + notTake;
    }

    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums)
        {
            totalSum += num;
        }
        int sum = (totalSum - target) / 2;
        if(totalSum - target < 0 || (totalSum - target) % 2 != 0)
        {
            return 0;
        }

        int[][] dp = new int[n][sum + 1];

        // Tabulation

        for(int j = 0;j <= sum;j++)
        {
            if(nums[0] == 0 && j == 0)
            {
                dp[0][j] = 2;
            }
            else if(nums[0] == j || j == 0)
            {
                dp[0][j] = 1;
            }
            else
            {
                dp[0][j] = 0;
            }
        }

        for(int idx = 1;idx < n;idx++)
        {
            for(int tar = 0;tar <= sum;tar++)
            {
                int notTake = dp[idx - 1][tar];
                int take = 0;
                if(nums[idx] <= tar)
                {
                    take = dp[idx - 1][tar - nums[idx]];
                }
                dp[idx][tar] = take + notTake;
            }
        }

        return dp[n - 1][sum];

        // Memoization

        // for(int i = 0;i < n;i++)
        // {
        //     for(int j = 0;j <= sum;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }

        // return fMemoi(n - 1,sum,nums,dp);

        // Recursion
        // return f(n - 1,sum,nums);

    }
}