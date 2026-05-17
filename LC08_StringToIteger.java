class Solution {
    public int myAtoi(String s) {


        long num = 0;
        
        boolean signPresent = false;
        boolean negative = false;
        boolean numberFound = false;

        s = s.trim();

        int i=0;

        while( i < s.length()){

            if( s.charAt(i) == '-' || s.charAt(i) == '+'){
                if( !signPresent && !numberFound ){
                    signPresent = true;
                }else{
                    break; // if one of the this sign appear again after one occurance we should break
                }

                if( s.charAt(i) == '-'){
                    negative = true;
                }

            }else if( (s.charAt(i) - '0' >= 0) && (s.charAt(i) - '0' <= 9)){
                numberFound = true;
                num = ( num * 10 ) + (s.charAt(i)-'0');

                if( num > Integer.MAX_VALUE ){
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }else{
                break;
            }

            i++;
        }


        if( num > Integer.MAX_VALUE){
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        return negative ? (int)-num : (int)num;
    }
}
