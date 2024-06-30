package algorithm;

/**
 * 合并两个有序链表
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        ListNode head = new ListNode(Math.max(list1.val, list2.val));
        ListNode res = head;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                head.next = new ListNode(list1.val);
                head = head.next;
                list1 = list1.next;
                continue;
            }
            head.next = new ListNode(list2.val);
            head = head.next;
            list2 = list2.next;
        }
        if(list1 != null){
            head.next = list1;
        }
        if(list2 != null){
            head.next = list2;
        }
        return res.next;

    }
}
