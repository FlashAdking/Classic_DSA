class Solution {
    public long minArraySum(int[] nums) {

        int max = nums[0];

        for(int i=0 ; i < nums.length ; i++){
            max = Math.max( max , nums[i]);

        }

        int[] track = new int[max+1];

        for(int i=0 ; i < nums.length ; i++){
            track[nums[i]] = nums[i];
        }


        for(int i=1 ; i <= max ; i++){
            

            if( track[i] == 0) continue;

            for( int j=i ; j <= max ; j+=i){

                if( track[j] != 0){

                    track[j] = Math.min( track[j] , i);
                }
            }
        }


        long sum = 0;

        for( int i=0 ; i < nums.length ; i++){

            sum += track[nums[i]];
        }

        return sum;
    }
}
