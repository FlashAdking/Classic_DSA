class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        int n = (int)Math.pow(2 , nums.length);
        int size = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        int count = 0;
        while( count < n){
            int val = count;
            List<Integer> ls = new ArrayList<>();
            int i = 0;
            while(i < size){
                if(((val >> i) & 1) == 1){
                    ls.add(nums[size-i-1]);
                }
                i++;
            }

            count++;
            ans.add(ls);
        }

        return ans;
    }
}
