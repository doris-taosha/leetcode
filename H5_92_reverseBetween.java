package top150;

/**
 *92. 反向链接列表 II

 * 给定一个单链表head 和两个整数left和right，left <= right将列表的节点从位置反转到left位置right，并返回反转后的列表。
 *
 */

public class H5_92_reverseBetween {

        public ListNode reverseBetween(ListNode head, int left, int right) {
        //处理边界
        if(head == null || left == right) return head;
        ListNode dummyHead = new ListNode(0, head); //虚拟头节点
        ListNode leftNode = dummyHead;
        for(int i = 0; i < left - 1; i++){
            leftNode = leftNode.next;
        }

        //准备开始反转
        ListNode newRight = leftNode.next;
        ListNode cur = newRight;
        ListNode prev = null;

        while(left <= right){
            ListNode tmp = cur.next; //临时记录下一个节点
            cur.next = prev; //反转操作
            prev = cur;
            cur = tmp;
            left++;
        }
        leftNode.next = prev;
        newRight.next = cur; //此时反转后的最后一个元素指向
        return dummyHead.next;
    }

}
