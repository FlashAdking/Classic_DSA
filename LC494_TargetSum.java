class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return SumTarget(0, nums , target ,0);
    }

    public int SumTarget(int idx ,int[] nums , int target , int sum){
        if( idx >= nums.length){
            return sum == target ? 1 : 0;
        }

        int plus = SumTarget(idx+1 , nums , target , sum + nums[idx]);
        int minus = SumTarget(idx+1 , nums , target , sum - nums[idx]);


        return plus + minus;
    }
}
