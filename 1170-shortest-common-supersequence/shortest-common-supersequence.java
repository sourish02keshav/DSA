class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1;i <= m;i++)
        {
            for(int j = 1;j <= n;j++)
            {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }

        String ans = "";
        int i = m,j = n;
        while(i > 0 && j > 0)
        {
            if(str1.charAt(i - 1) == str2.charAt(j - 1))
            {
                ans = str1.charAt(i - 1) + ans;
                i = i - 1;
                j = j - 1;
            }
            else if(dp[i - 1][j] > dp[i][j - 1])
            {
                ans = str1.charAt(i - 1) + ans;
                i = i - 1;
            }
            else
            {
                ans = str2.charAt(j - 1) + ans;
                j = j - 1;
            }
        }
        while(i > 0)
        {
            ans = str1.charAt(i - 1) + ans;
            i = i - 1;
        }
        while(j > 0)
        {
            ans = str2.charAt(j - 1) + ans;
            j = j - 1;
        }

        return ans;
    }
}