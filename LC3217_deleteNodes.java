/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        Set<Integer> set = new HashSet<>();

        for(int i: nums){
            set.add(i);
        }

        ListNode dummy = new ListNode(-1 , head);
        ListNode curr = dummy;
        ListNode iterator = head;

        while( iterator != null){

            // if( set.contains(iterator.val) ){
            //     while( iterator != null && set.contains(iterator.val)){
            //         iterator = iterator.next;
            //     }
            //     curr.next = iterator;
            //     // curr = curr.next;
            // }

            // curr = iterator;
            
            if(set.contains(iterator.val)){
                curr.next = iterator.next;
            }else{
                curr = iterator;
            }


            // if(iterator == null) break;
            iterator = iterator.next;

        }

        return dummy.next;

    }
}
