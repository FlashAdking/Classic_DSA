class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int most_freq = 0;
        int[] index = new int[26];
        int max = 0;

        index[s.charAt(0)-'A']++;

        while( j < s.length()){
            most_freq = Math.max(most_freq , index[s.charAt(j)-'A']);
            int val = (j-i+1) - most_freq;
            if(val <= k){
                max = Math.max(max , (j-i)+1);
                j++;
                if(j == s.length()) break;
                index[s.charAt(j) - 'A']++;
            }else{
                index[s.charAt(i) - 'A']--;
                i++;
            }
        }

        return max;
    }
}
