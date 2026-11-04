class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
        {
            return s;
        }
        String ans = "";
        for(int i = 1;i < s.length();i++)
        {
            // For Odd no of substring
            int left = i;
            int right = i;

            while(s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
                if(left < 0 || right == s.length())
                {
                    break;
                }
            }

            String palindrome = s.substring(left + 1,right);
            if(palindrome.length() > ans.length())
            {
                ans = palindrome;
            }

            // For even no of substring

            left = i - 1;
            right = i;

            while(s.charAt(left) == s.charAt(right))
            {
                left--;
                right++;
                if(left < 0 || right == s.length())
                {
                    break;
                }
            }

            palindrome = s.substring(left + 1,right);
            if(palindrome.length() > ans.length())
            {
                ans = palindrome;
            }
        }
        return ans;
    }
}