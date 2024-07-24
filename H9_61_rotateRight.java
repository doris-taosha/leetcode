package top150;


/***
 * 61. 旋转列表
 * 给定一个链接列表head，将列表按k位置向右旋转。
 *
 * 示例 1：
 * 输入： head = [1,2,3,4,5], k = 2
 * 输出： [4,5,1,2,3]
 *
 *
 * 示例 2：
 * 输入： head = [0,1,2], k = 4
 * 输出： [2,0,1]
 */

public class H9_61_rotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int len = getLength(head);
        if(k % len == 0) return head;
        k = len > k ? k : k % len;

        ListNode cur = head;
        for(int i = 0; i < len - k - 1; i++){
            cur = cur.next;
        }

        ListNode res = cur.next;
        cur.next = null;
        ListNode tail = res;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = head;
        return res;




    }


    private int getLength(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
