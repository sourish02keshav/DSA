class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m * k > bloomDay.length)
        {
            return -1;
        }
        int low = Integer.MAX_VALUE,high = 0;
        for(int num : bloomDay)
        {
            low = num < low ? num : low;
            high = num > high ? num : high;
        }
        int ans = -1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(canMake(bloomDay,m,k,mid))
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
    public boolean canMake(int[] arr,int m,int k,int mid)
    {
        int count = 0,currCount = 0;
        for(int num : arr)
        {
            if(num <= mid)
            {
                currCount++;
            }
            else
            {
                currCount = 0;
            }
            if(currCount == k)
            {
                count++;
                currCount = 0;
            }
        }
        return count >= m;
    }
}