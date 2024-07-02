package algorithm;

import java.util.HashMap;

/**
 *  随机链表的复制
 *
 */
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node res = new Node(-1);
        Node node = res;
        Node temp = head;
        HashMap<Node, Node> mapNode = new HashMap<>();
        while (temp != null){
            node.next = new Node(temp.val);
            mapNode.put(temp, node.next);
            node = node.next;
            temp = temp.next;
        }
        while (head != null){
            if(head.random == null){
                head = head.next;
                continue;
            }
            Node randomHead = head.random;
            Node randomTemp = mapNode.get(randomHead);
            Node nodeTemp = mapNode.get(head);
            nodeTemp.random = randomTemp;
            head = head.next;
        }
        return res.next;

    }
}
