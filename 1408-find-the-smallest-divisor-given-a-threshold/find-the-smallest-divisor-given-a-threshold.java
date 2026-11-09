class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num : nums)
        {
            high = num > high ? num : high;
        }
        int ans = -1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(calSum(nums,mid) <= threshold)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int calSum(int[] arr,int div)
    {
        int sum = 0;
        for(int num : arr)
        {
            if(num % div == 0)
            {
                sum += num / div;
            }
            else
            {
                sum += num / div + 1;
            }
        }
        return sum;
    }
}