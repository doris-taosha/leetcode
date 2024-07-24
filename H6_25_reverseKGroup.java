package top150;


/***
 *
 * 25. 反转 k 组中的节点

 * 给定一个链表的，一次head反转列表的节点，并返回修改后的列表。k
 *
 * k是一个正整数，并且小于或等于链表的长度。如果节点数不是的倍数k，那么最后遗漏的节点应该保持原样。
 *
 * 您可能无法改变列表节点中的值，只有节点本身可以​​更改。
 */
public class H6_25_reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;

        ListNode start = head;
        ListNode end = head;
        ListNode newHead = head;
        ListNode prev = new ListNode();

        while(end != null){
            count++;
            if(count == k) newHead = end; //找到头
            if(count % k == 0){
                ListNode tmp = end.next;
                ListNode newNode = revrese(start, end, k);
                prev.next = newNode;
                prev = start;
                start = tmp;
                end = start;
            }else{
                end = end.next;
            }
        }
        return newHead;
    }

    public ListNode revrese(ListNode start, ListNode end, int k) {
        ListNode cur = start;
        ListNode prev = end.next;
        ListNode next = null;

        for(int i = 0; i < k; i++){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    }
