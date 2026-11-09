class Solution {
    public int mySqrt(int x) {
        int low = 1;
        int high = x / 2 + 1;
        int ans = 0;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if((long)mid * mid <= (long)x)
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }
}