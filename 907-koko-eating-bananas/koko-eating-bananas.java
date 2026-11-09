class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int num : piles)
        {
            high = num > high ? num : high;
        }
        int ans = 0;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(canEat(piles,mid) <= h)
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
    public long canEat(int[] arr,int h)
    {
        long count = 0;
        for(int num : arr)
        {
            if(num % h == 0)
            {
                count += num / h;
            }
            else
            {
                count += num / h + 1;
            }
        }
        return count;
    }
}