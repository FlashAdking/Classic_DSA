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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

        ListNode num1 = l1;
        ListNode num2 = l2;
        ListNode res = null;
        ListNode curr = null;
        int carry = 0;

        while(num1 != null && num2 != null){
            int sum = num1.val + num2.val + carry;
            ListNode New_Node = new ListNode();
            New_Node.val = sum % 10;
            New_Node.next = null;

            if(res == null){
                res = New_Node;
                curr = New_Node;
            }else{
                curr.next = New_Node;
                curr = curr.next;
            }

            carry = sum / 10;

            num1 = num1.next;
            num2 = num2.next;
        }


        ListNode remain = num1 != null ? num1 : num2;

        while(remain != null){
            int sum = remain.val + carry;

            ListNode New_Node = new ListNode(sum % 10 , null);

            curr.next = New_Node;
            curr = curr.next;

            carry = sum / 10;
            remain = remain.next;
        }

        if( carry != 0){
            ListNode New_Node = new ListNode(carry , null);
            curr.next = New_Node;
        }

        
        return res;

    }
}
