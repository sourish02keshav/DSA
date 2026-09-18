class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // Space Optimization - TC 
        boolean[] prev = new boolean[n + 1];
        prev[0] = true;
        for(int j = 1;j <= n;j++)
        {
            prev[j] = true;
            for(int k = 1;k <= j;k++)
            {
                if(p.charAt(k - 1) != '*')
                {
                    prev[j] = false;
                    break;
                }
            }
        }

        for(int i = 1;i <= m;i++)
        {
            boolean[] curr = new boolean[n + 1];
            for(int j = 1;j <= n;j++)
            {
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                {
                    curr[j] = prev[j - 1];
                }
                else if(p.charAt(j - 1) == '*')
                {
                    curr[j] = prev[j] || curr[j - 1];
                }
            }
            prev = curr;
        }
        return prev[n];


        // Tabulation - TC - O(m * n) and SC - O(m * n)
        // boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0] = true;
        // for(int i = 1;i <= m;i++)
        // {
        //     dp[i][0] = false;
        // }
        // for(int j = 1;j <= n;j++)
        // {
        //     boolean flag = true;
        //     for(int k = 1;k <= j;k++)
        //     {
        //         if(p.charAt(k - 1) != '*')
        //         {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     dp[0][j] = flag;
        // }

        // for(int i = 1;i <= m;i++)
        // {
        //     for(int j = 1;j <= n;j++)
        //     {
        //         if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
        //         {
        //             dp[i][j] = dp[i - 1][j - 1];
        //         }
        //         else if(p.charAt(j - 1) == '*')
        //         {
        //             dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        //         }
        //     }
        // }
        // return dp[m][n];

        // Memoization
        // int[][] dp = new int[m + 1][n + 1];
        // for(int i = 0;i <= m;i++)
        // {
        //     for(int j = 0;j <= n;j++)
        //     {
        //         dp[i][j] = -1;
        //     }
        // }
        // return fMemoi(m,n,s,p,dp);

        // Recursion - TC - O(exponential) and SC - O(m + n)
        // return f(m,n,s,p);
    }

    public boolean fMemoi(int i,int j,String s,String p,int[][] dp)
    {
        if(i == 0 && j == 0)
        {
            return true;
        }
        if(i > 0 && j == 0)
        {
            return false;
        }
        if(i == 0 && j > 0)
        {
            boolean flag = true;
            for(int k = 1;k <= j;k++)
            {
                if(p.charAt(k - 1) != '*')
                {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j] == 1;
        }
        boolean ans = false;
        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
        {
            ans = fMemoi(i - 1,j - 1,s,p,dp);
        }
        else if(p.charAt(j - 1) == '*')
        {
            ans = fMemoi(i - 1,j,s,p,dp) || fMemoi(i,j - 1,s,p,dp);
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean f(int i,int j,String s,String p)
    {
        if(i == 0 && j == 0)
        {
            return true;
        }
        if(i > 0 && j == 0)
        {
            return false;
        }
        if(i == 0 && j > 0)
        {
            boolean flag = true;
            for(int k = 1;k <= j;k++)
            {
                if(p.charAt(k - 1) != '*')
                {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
        {
            return f(i - 1,j - 1,s,p);
        }
        else if(p.charAt(j - 1) == '*')
        {
            return f(i - 1,j,s,p) || f(i,j - 1,s,p);
        }
        else
        {
            return false;
        }
    }
}