class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        
        int[][] dp = new int[n][2];

        for(int i=0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1005);
        }


        int balance = recBal(0 , 0 , stoneValue ,dp);

        return  balance > 0 ? "Alice" : (balance < 0 ? "Bob" : "Tie");
    }

    public int recBal(int idx , int turn , int[] stone ,int[][] dp){
        if( idx >= stone.length) return 0;
        if( dp[idx][turn] != -1005) return dp[idx][turn];


        if( turn == 0){

            int first = stone[idx] - recBal(idx+1 , 1 , stone , dp);

            int second = -1002;
            int third = -1002;

            if(idx+1 < stone.length){
                second = (stone[idx] + stone[idx+1]) - recBal(idx+2 , 1 , stone , dp);
            }

            if( idx+2 < stone.length){
                third = (stone[idx] + stone[idx+1] + stone[idx+2]) - recBal(idx+3 , 1 , stone ,dp);
            }

            dp[idx][turn] = Math.max(first , Math.max(second , third ));
            return dp[idx][turn];
        }else{

            int first = stone[idx] - recBal(idx+1 , 0 , stone ,dp);

            int second = -1002;
            int third = -1002;

            if(idx+1 < stone.length){
                second = (stone[idx] + stone[idx+1]) - recBal(idx+2 , 0 , stone, dp);
            }

            if( idx+2 < stone.length){
                third = (stone[idx] + stone[idx+1] + stone[idx+2]) - recBal(idx+3 , 0 , stone, dp);
            }


            dp[idx][turn] = Math.max(first , Math.max(second , third ));
            return dp[idx][turn];
        }
    }
}
