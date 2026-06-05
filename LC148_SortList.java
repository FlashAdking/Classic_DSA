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
    public ListNode sortList(ListNode head) {
        if( head == null ) return head;

        return MergeSort(head);
    }

    public ListNode GetMidNode(ListNode root){
        ListNode slow = root;
        ListNode fast = root.next;

        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode MergeSort(ListNode root){
        if( root == null || root.next == null) return root;


        ListNode slow = GetMidNode(root);
        ListNode right = slow.next;
        slow.next = null;

        ListNode leftSorted = MergeSort(root);
        ListNode rightSorted = MergeSort(right);

        return merge( leftSorted , rightSorted );
    }

    public ListNode merge( ListNode root1 , ListNode root2){
        if( root1 == null ) return root2;
        if( root2 == null ) return root1;

        ListNode left_dummy = new ListNode(-1 , root1);

        ListNode i = root1;
        ListNode j = root2;

        while( i != null && j != null ){
            if( i.val < j.val){
                i = i.next;
            }else{
                ListNode prev = j;
                j = j.next;
                prev.next = i;
                left_dummy.next = prev;
            }

            left_dummy = left_dummy.next;
        }

        if( i == null){
            left_dummy.next = j;
        }

        return root1.val < root2.val ? root1 : root2;

    }
}
