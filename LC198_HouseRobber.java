class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp , -1);

        return robber(0 , nums , dp);
    }

    public int robber(int idx , int[] nums , int[] dp){
        if( idx >= nums.length) return 0;
        if( dp[idx] != -1) return dp[idx];

        int n_take = robber( idx + 1 , nums , dp);

        int take = nums[idx] + robber( idx + 2 , nums , dp);

        dp[idx] = Math.max(take , n_take);

        return dp[idx];
    }
}
