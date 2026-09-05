class Solution {

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
        return f(n - 1,sum,nums);

    }
}