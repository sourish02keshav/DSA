class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for(int i = 0;i < n;i++)
        {
            totSum += nums[i];
        }
        if(totSum % 2 != 0)
        {
            return false;
        }
        else
        {
            return isSubsetSum(n,totSum / 2,nums);
        }
    }

    public boolean isSubsetSum(int n,int sum,int[] arr) {

        // Tabulation

        boolean[][] dp = new boolean[n][sum + 1];
        for(int i = 0;i < n;i++)
        {
            dp[i][0] = true;
        }
        if(arr[0] <= sum)
        {
            dp[0][arr[0]] = true;
        }

        for(int idx = 1;idx < n;idx++)
        {
            for(int target = 1;target <= sum;target++)
            {
                boolean notTake = dp[idx - 1][target];
                boolean take = false;
                if(arr[idx] <= target)
                {
                    take = dp[idx - 1][target - arr[idx]];
                }
                dp[idx][target] = notTake || take;
            }
        }

        return dp[n - 1][sum];

        // Memoization
        // int[][] dp = new int[n][sum + 1];
        // for(int i = 0;i < n;i++)
        // {
        //     for(int j = 0;j <= sum;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }

        // return fMemoi(n - 1,sum,arr,dp);

        // Recursion
        // return f(n - 1,sum,arr);

    }

    public boolean fMemoi(int idx,int sum,int[] arr,int[][] dp)
    {
        if(sum == 0)
        {
            return true;
        }
        if(idx == 0)
        {
            return arr[idx] == sum;
        }
        if(dp[idx][sum] != -1)
        {
            return dp[idx][sum] == 1;
        }
        boolean notTake = fMemoi(idx - 1,sum,arr,dp);
        boolean take = false;
        if(arr[idx] <= sum)
        {
            take = fMemoi(idx - 1,sum - arr[idx],arr,dp);
        }
        dp[idx][sum] = notTake || take ? 1 : 0;
        return notTake || take;
    }

    public boolean f(int idx,int sum,int[] arr)
    {
        if(sum == 0)
        {
            return true;
        }
        if(idx == 0)
        {
            return arr[0] == sum;
        }
        boolean notTake = f(idx - 1,sum,arr);
        boolean take = false;
        if(arr[idx] <= sum)
        {
            take = f(idx - 1,sum - arr[idx],arr);
        }
        return take || notTake;
    }
}