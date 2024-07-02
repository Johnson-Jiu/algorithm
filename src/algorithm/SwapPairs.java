package algorithm;

/**
 * 两两交换链表中的节点
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = head.next;
        ListNode temp = res;
        ListNode pre = null;
        ListNode next = null;
        //画图辅助理解
        while (head != null && head.next != null) {
            pre = head;
            next = head.next;
            head = head.next.next;
            pre.next = head;
            next.next = pre;
            temp.next = next;
            temp = pre;
        }
        return res.next;
    }

}

/*
递归解法
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
*/


