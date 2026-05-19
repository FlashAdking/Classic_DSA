class Solution {
    public int search(int[] nums, int target) {
        return BinarySearch(0 , nums.length-1 , nums , target);
    }

    public int BinarySearch(int low , int high , int[] nums , int target){

        while( low <= high){
            int mid = low + (high - low) / 2;

            if( nums[mid] == target) return mid;

            // each time eliminate sorted part or dive into sorted one
            if( nums[low] <= nums[mid] ){
                
                if( target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }


            }else{

                if( target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }


        return -1;
    }
}
