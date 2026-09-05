class Solution {

    int f(int idx,int target,int[] arr)
    {
        if(idx == 0)
        {
            if(arr[0] == 0 && target == 0)
            {
                return 2;
            }
            else if(target == 0 || arr[0] == target)
            {
                return 1;
            }
            else 
            {
                return 0;
            }
        }
        int notTake = f(idx - 1,target,arr);
        int take = 0;
        if(arr[idx] <= target)
        {
            take = f(idx - 1,target - arr[idx],arr);
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
        else
        {
            return f(n - 1,sum,nums);
        }
    }
}