package algorithm;

import org.junit.Test;

/**
 * 环形链表 II
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode head1 = head;
        ListNode head2 = head;
        boolean flag = false;
        while (head2.next != null && head2.next.next != null){
            head1 = head1.next;
            head2 = head2.next.next;
            if(head1 == head2){
                flag = true;
                break;
            }
        }
        if(flag){
            while(head != head2){
                head = head.next;
                head2 = head2.next;
            }
            return head2;
        }else{
            return null;
        }
    }

    @Test
    public void test(){
/*        ListNode head = new ListNode(-1);
        head.next = new ListNode(-7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = new ListNode(19);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(-9);
        head.next.next.next.next.next.next.next = new ListNode(-5);
        head.next.next.next.next.next.next.next.next = new ListNode(-2);
        head.next.next.next.next.next.next.next.next.next = new ListNode(-5);
        head.next.next.next.next.next.next.next.next.next.next = head.next.next.next.next.next.next;*/
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode res = detectCycle(head);
        System.out.println(res.val);
    }
}

/*public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}*/





