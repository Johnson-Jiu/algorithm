package LeetCode.链表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class SortList {

    @Test
    public void test(){
        ListNode list = new ListNode(-1,new ListNode(5,new ListNode(3,new ListNode(4,new ListNode(0)))));
        sortList1(list);
    }



    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        list.sort(Comparator.naturalOrder());
        if(list.size() > 0){
            int length = list.size();
            ListNode listNode = new ListNode();
            ListNode head1 = listNode;
            int i = 0;
            while (i < length){
                listNode.next = new ListNode(list.get(i));
                listNode = listNode.next;
                i++;
            }
            return head1.next;
        }else{
            return null;
        }
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList1(head);
        ListNode right = sortList1(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

}
