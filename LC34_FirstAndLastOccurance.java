class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = BinarySearchLeft(0 , nums.length-1 , nums , target , true);

        int right = BinarySearchLeft(left+1 , nums.length-1 , nums , target , false);

        if( right == -1) return new int[]{ left , left };


        return new int[]{left , right};
    }

    public int BinarySearchLeft(int start , int end , int[] nums , int target , boolean trigger){
        int index = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if( nums[mid] == target){
                index = mid;
                if(trigger){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if( nums[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }

        }

        return index;
    }

    // public int BinarySearchRight(int start , int end , int[] nums , int target){
    //     int index = -1;



    //     while(start <= end){
    //         int mid = start + (end - start) / 2;

    //         if( nums[mid] == target){
    //             index = mid;
    //             start = mid+1;
    //         }else if( nums[mid] > target){
    //             end = mid-1;
    //         }else{
    //             start = mid+1;
    //         }

    //     }

    //     return index;
    // }
}
