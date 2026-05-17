class Solution {
    public double myPow(double x, int n) {
        
        long exp = n;

        if( n < 0){
            exp = -exp;
            x = 1.0/x;
        } 

        return power(x , exp , 1.0);
    }

    public double power(double x , long binform , double ans){

        if( binform == 0){
            return ans;
        }


        if( (binform & 1) == 1){
            ans *= x;
        }


        return power( x*x , binform >> 1 , ans);
    }
}
