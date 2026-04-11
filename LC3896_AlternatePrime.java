class Solution {
    public int minOperations(int[] nums) {


        int count = 0;
    
        for(int i=0 ; i < nums.length ; i++){

            if( i % 2 == 0){

                int n = nums[i];
                while( !isPrime(n)){
                    count++;
                    n++;
                }
                
            }else{

                int n = nums[i];
                while( isPrime(n) ){
                    count++;
                    n++;
                }
            }
            
        }

        return count++;
    }


    public boolean isPrime(int n){

        if( n==1) return false;
        
        if( n == 2 || n == 3) return true;

        if( n % 2 == 0 || n % 3 == 0) return false;

        int sqrt = (int)Math.sqrt(n);

        for( int i=5 ; i <= sqrt ; i+=6){
            if(n % i == 0 ||  n % (i+2) == 0) return false;
        }


        return true;
    }
}
