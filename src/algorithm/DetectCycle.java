package algorithm;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode head1 = head;
        ListNode head2 = head.next.next;
        while (head2 != null){
            head1 = head1.next;
            if(head2.next == null){
                break;
            }
            head2 = head2.next.next;
            if(head == head2){
                break;
            }
        }
        if(head1 != head2){
            return null;
        }

        while (head != head2){
            head = head.next;
            if(head == head2){
                return head;
            }
            head2 = head2.next;
        }
        return head;
    }
}


/**



 }
 return head == head2;