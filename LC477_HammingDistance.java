class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int sum = 0;
        for(int i=0 ; i < 32 ; i++){
            int one = 0;

            for(int num : nums){
                one += (num >> i) & 1;
            }

            sum += one * (nums.length - one);

        }

        return sum;
    }
}
