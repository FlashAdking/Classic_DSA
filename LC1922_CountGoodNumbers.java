class Solution {

    long MAX = 1000000007l;
    public int countGoodNumbers(long n) {
        


        long res = 1;

        if( n % 2 != 0){
            res = 5;
            n--;
        }
        
        long even = n/2l;

        res = ((res * power(5l , even)) % MAX);
        res = ((res * power(4l , even)) % MAX);

        return (int)(res % MAX);

    }

    public long power(long x , long n){

        long ans = 1;
        

        while( n > 0){

            if( n % 2 != 0){
                ans = ((ans * x) % MAX);
                n--;
            }

            x = ((x * x) % MAX);
            n >>= 1;
        }


        return ans % MAX;
    }

   
}
