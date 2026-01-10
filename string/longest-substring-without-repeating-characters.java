class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last = new int [256];
        int left = 0, max = 0;
        for ( int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            if ( last[c] >= left){
                left = left + last[c];
            }
            last[c] = right;
            max = Math.max( max, right - left);
        }
        return max;
    }
}