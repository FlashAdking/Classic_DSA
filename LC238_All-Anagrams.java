class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if( s.length() < p.length()) return new ArrayList();

        int[] index = new int[26];
        int[] org = new int[26];


        for(int i=0; i < p.length() ; i++){
            index[s.charAt(i) - 'a']++;
            org[p.charAt(i)-'a']++;
        }
        

        List<Integer> solution = new ArrayList<>();

        int j=p.length();
        int i;

        for(i=0 ; i <= s.length()-p.length() ; i++){
            if( isAnagram(index , org)){
                solution.add(i);
            }

            index[ s.charAt(i)-'a']--;
            if(j >= s.length()) break;
            index[ s.charAt(j)-'a']++;
            
            j++;
        }

        // index[ s.charAt(i) - 'a']--;
        // index[ s.charAt(j)-'a']++;


        return solution;
    }

    public boolean isAnagram(int[] arr1 , int[] arr2){

        for(int i=0 ; i < 26 ; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}
