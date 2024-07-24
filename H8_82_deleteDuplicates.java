package top150;


/**
 *
 * 82. 从排序列表中删除重复项 II

 * 给定一个排序好的链表head ，删除所有有重复数字的节点，只留下与原列表不同的数字。返回排序后的链表。
 *
 * 示例 1：
 * 输入： head = [1,2,3,3,4,4,5]
 * 输出： [1,2,5]
 *
 * 示例 2：
 * 输入： head = [1,1,1,2,3]
 * 输出： [2,3]
 */
public class H8_82_deleteDuplicates {


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                //此时head 在最后一个相同的节点上
                //head.next才是下一个不相同的数
                cur.next = head.next;
            }else{
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;

    }
}
