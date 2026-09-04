class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0,r = 0;
        int m = g.length;
        int n = s.length;
        while(r < n)
        {
            if(l >= m)
            {
                break;
            }
            if(g[l] <= s[r])
            {
                l = l + 1;
            }
            r = r + 1;
        }   
        return l;
    }
}