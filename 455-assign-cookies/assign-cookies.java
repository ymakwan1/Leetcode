class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0, r = 0;

        while(l < m && r < n){
            if(s[l] >= g[r]){
                r++;
            }
            l++;
        }

        return r;
    }
}