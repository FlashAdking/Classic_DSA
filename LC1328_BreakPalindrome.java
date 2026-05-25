class Solution {
    public String breakPalindrome(String palindrome) {
        if( palindrome.length() == 1) return "";
         
        char[] str = palindrome.toCharArray();


        // change first non 'a' to 'a'
        for( int i=0 ; i < str.length/2 ; i++){
            if( str[i] != 'a' ){
                str[i] = 'a';

                return new String(str);
            }
        }

        // what is all are a's
        str[str.length-1] = 'b';

        return new String(str);
    }
}
