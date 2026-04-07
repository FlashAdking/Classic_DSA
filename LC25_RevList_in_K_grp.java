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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(-1 , head);
        ListNode prev_window = dummy;
        ListNode start_k = dummy.next;
        ListNode end_k = dummy.next;
        ListNode next_window = null;

        while( end_k != null ){
            int count = 1;

            while(count < k && end_k != null){
                end_k = end_k.next;
                count++;
            }

            if(end_k == null){
                break;
            }

            next_window = end_k.next;
            end_k.next = null;

            ListNode[] reverseArray = reverseList(start_k);

            prev_window.next = reverseArray[0];
            reverseArray[1].next = next_window;

            prev_window = reverseArray[1];
            start_k = prev_window.next;
            end_k = prev_window.next;
        }

        return dummy.next;
    }

    public ListNode[] reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        return new ListNode[]{prev , head};
    }
}
