class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        
        StringBuilder str = new StringBuilder();

        for( String i : chunks){
            str.append(i);
        }


        char[] clear = str.toString().toCharArray();


        for(int i=0 ; i < clear.length ; i++){
            if( clear[i] == '-' && isValidSeparator(i , clear)){
                clear[i] = ' ';
            }
        }

        Map<String , Integer> map = new HashMap<>();

        for( int i=0 ; i < queries.length ; i++){
            map.put( queries[i] , 0);
        }


        String s = new String(clear);


        int i=0;
        int j=1;

        s = s.trim();
        // System.out.println(s);

        while( j <= s.length() ){
            if( j == s.length() || s.charAt(j) == ' '){  
                

                if( i < j){
                    String substr = s.substring(i , j);
                    map.computeIfPresent( substr , (k , v) -> v+1);
                }

                i = j+1;
            }            
            j++;
        }

        int[] ans = new int[queries.length];

        for( int iter=0 ; iter < queries.length ; iter++){
            ans[iter] = map.get(queries[iter]);
        }

        return ans;
    }

    public boolean isValidSeparator(int index , char[] arr){
        if( index == 0 || index >= arr.length-1) return true; //it is seperator

        if( (arr[index-1] >= 'a' && arr[index-1] <= 'z') &&
            ( arr[index+1] >= 'a' && arr[index+1] <= 'z') ){
                return false; //it is not a seperator
            }

        return true; //it is separator
    }
}
