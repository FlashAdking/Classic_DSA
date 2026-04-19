class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] postMin = new int[nums.length];

        postMin[nums.length-1] = nums[nums.length-1];

        for( int i=nums.length-2 ; i >= 0 ; i--){
            postMin[i] = Math.min(nums[i] , postMin[i+1]);
        }

        int max = nums[0];

        for(int i=0 ; i < nums.length ; i++){
            
            max = Math.max(max , nums[i]);
            if( max - postMin[i] <= k) return i;
        }

        return -1;
    }
}
