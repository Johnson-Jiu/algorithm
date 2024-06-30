package algorithm;

/**
 * 两数相加
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        ListNode node = new ListNode(-1);
        ListNode head = node;
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        while (l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int add = val1 + val2 + temp;
            head.next = new ListNode(add % 10);
            head = head.next;
            temp = add >= 10 ? add / 10 : 0;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(temp != 0){
            head.next = new ListNode(temp);
        }
        return node.next;
    }
}
