package algorithm;

import org.junit.Test;


/**
 * 回文链表
 * 输入：head = [1,2,2,1]
 * 输出：true
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2.next != null && node2.next.next != null){
            node1 = node1.next;
            node2 = node2.next.next;
        }
        ListNode revHalf = reverseList(node1.next);
        while (revHalf != null){
            if(revHalf.val != head.val){
                return false;
            }
            revHalf = revHalf.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 双指针
/*    ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
        list.add(head.val);
        head = head.next;
    }
    int left = 0, right = list.size() - 1;
        while (left < right){
        if(!list.get(left).equals(list.get(right))){
            return false;
        }
        left++;
        right--;
    }
        return true;*/

    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(listNode));
    }
}
