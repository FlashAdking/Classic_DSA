class Solution {
    public String countAndSay(int n) {
        
        return countSay("1" ,1 , n);
    }

    public String countSay(String str , int cnt , int n){
        if( cnt == n){
            return str;
        }

        StringBuilder local_str = new StringBuilder();
        char ele = str.charAt(0);
        int count = 0;

        for( int i=0 ; i < str.length() ; i++){
            if(ele == str.charAt(i)){
                count++;
            }else{
                local_str.append(count);
                local_str.append(ele);

                ele = str.charAt(i);
                count = 1;
            }
        }

        local_str.append(count);
        local_str.append(ele);



        return countSay(local_str.toString() , cnt + 1 , n);

    }

}
