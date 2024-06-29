package algorithm;

/**
 * 环形链表
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode head2 = head.next.next;
        while (head2 != null && head2 != head){
            head = head.next;
            if(head2.next == null){
                break;
            }
            head2 = head2.next.next;
        }
        return head == head2;
    }
}
