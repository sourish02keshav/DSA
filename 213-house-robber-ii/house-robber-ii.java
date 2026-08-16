class Solution {

    int robHelper(int[] arr)
    {
        int n = arr.length;
        int prev = arr[0];
        int prev2 = 0;
        for(int i = 1;i < n;i++)
        {
            int take = arr[i] + prev2;
            int notTake = prev;
            int currSum = Math.max(take,notTake);
            prev2 = prev;
            prev = currSum;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0)
        {
            return 0;
        }
        if(n == 1)
        {
            return nums[0];
        }
        int[] temp1 = new int[n - 1];
        int[] temp2 = new int[n - 1];
        for(int i = 0;i < n;i++)
        {
            if(i != 0)
            {
                temp1[i - 1] = nums[i];
            }
            if(i != n - 1)
            {
                temp2[i] = nums[i];
            }
        }
        return Math.max(robHelper(temp1),robHelper(temp2));
    }
}