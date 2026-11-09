class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0,high = 0;
        for(int num : weights)
        {
            low = num > low ? num : low;
            high += num;
        }
        int ans = -1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(canShip(weights,days,mid))
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
    public boolean canShip(int[] arr,int days,int wt)
    {
        int count = 1;
        int temp = wt;
        int i = 0;
        while(i < arr.length)
        {
            if(arr[i] <= temp)
            {
                temp -= arr[i];
                i++;
            }
            else
            {
                temp = wt;
                count++;
            }
        }
        return count <= days;
    }
}