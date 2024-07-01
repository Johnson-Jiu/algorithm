package algorithm;

/**
 * 删除链表的倒数第 N 个结点
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class RemoveNthFromEnd {
    int i= 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            i = 0;
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        i++;
        return i == n ? head.next : head;
    }

    private ListNode rev(ListNode head){
        ListNode pre = null;
        ListNode next ;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}

// 思路1，递归
// 思路2，栈 先进后出
// 思路3，双指针，快的比慢的多走了n步
