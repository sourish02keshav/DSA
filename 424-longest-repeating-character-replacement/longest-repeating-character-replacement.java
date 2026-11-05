class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0,maxFrequency = 0,maxLength = 0;
        int[] hash = new int[26];
        for(int right = 0;right < s.length();right++)
        {
            char ch = s.charAt(right);
            hash[ch - 'A']++;
            maxFrequency = Math.max(maxFrequency,hash[ch - 'A']);
            int changes = (right - left + 1) - maxFrequency;
            if(changes > k)
            {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            if(changes <= k)
            {
                maxLength = Math.max(maxLength,right - left + 1);
            }
        }
        return maxLength;
    }
}