class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();


        validParenthesis(n , 0 , new StringBuilder() , res);

        return res;
    }

    public void validParenthesis(int n , int open , StringBuilder str , List<String> answer){
        if( n == 0){
            answer.add(str.toString());
            return;
        }

        if( open > n) return; 

        // add open
        validParenthesis(n , open+1 , str.append("(") , answer);
        str.deleteCharAt(str.length()-1);

        // add close 
        if( open > 0){
            validParenthesis(n-1 , open-1 , str.append(")") , answer);
            str.deleteCharAt(str.length()-1);
        }


    }
}
