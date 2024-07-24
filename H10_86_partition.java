package top150;


/***
 *
 *86. 分区列表
 * 给定一个链接列表head 和一个值x，对其进行分区，使得所有小于x的节点都位于 大于或等于的x节点之前。
 * 您应该保留两个分区中每个分区的节点的原始相对顺序。
 *
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */
public class H10_86_partition {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ListNode smallHead = new ListNode(0);
        ListNode curSmall = smallHead;

        ListNode bigHead = new ListNode(0);  //大元素的头节点
        ListNode curBig = bigHead;
        while(head != null){

            if(head.val < x){
                curSmall.next = head;
                curSmall = curSmall.next;
            }else{
                curBig.next = head;
                curBig = curBig.next;
            }
            head = head.next;
        }

        curSmall.next = bigHead.next; //连接
        curBig.next = null;
        return smallHead.next;

    }

}
