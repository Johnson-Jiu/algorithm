package LeetCode.链表;

import org.junit.Test;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = reverseList(l1);
        ListNode list2 = reverseList(l2);
        ListNode res = new ListNode();
        ListNode head = res;
        int temp = 0;
        while (list1 != null || list2 != null){

            int i = list1 == null? 0: list1.val;
            int j = list2 == null? 0: list2.val;
            int sum = i + j + temp;
            res.val = sum % 10;
            temp = sum / 10;
            list1 = list1 == null? null : list1.next;
            list2 = list2 == null? null : list2.next;
            if(list1 == null && list2 == null){
                break;
            }
            res.next = new ListNode();
            res = res.next;
        }
        if(temp != 0){
            res.next = new ListNode(temp);
            res = res.next;
        }

        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;
    }

    /**
     *
     [7,2,4,3]
     [5,6,4]
     */

    @Test
    public void test(){
        ListNode listNode1 = new ListNode(7,new ListNode(2,new ListNode(4,new ListNode(3))));
        ListNode listNode2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        addTwoNumbers(listNode1,listNode2);
    }
}
