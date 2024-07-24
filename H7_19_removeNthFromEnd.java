package top150;


/**
 *19. 从列表末尾删除第 N 个节点

 * 给定head一个链接列表，从列表末尾删除节点并返回其头
 *
 * 示例 1：
 * 输入： head = [1,2,3,4,5], n = 2
 * 输出： [1,2,3,5]
 *
 * 示例 2：
 * 输入： head = [1], n = 1
 * 输出： []
 *
 * 示例 3：
 * 输入： head = [1,2], n = 1
 * 输出： [1]
 *
 */
public class H7_19_removeNthFromEnd {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode nextNode = new ListNode(2,
                new ListNode(3,
                        new ListNode(4,
                                new ListNode(5))));
        head.next = nextNode;
        System.out.println(removeNthFromEnd(head, 2));

    }
    //利用双指针
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        for(int i = 0; i < n; i++){
            head = head.next;
        }

        while(head != null){
            head = head.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return dummy.next;

    }


        //计算链表的长度， 然后遍历到len - n
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head == null) return head;
        //首先要知道链表的总共长度，
        ListNode cur = head;

        int len = 0;
        while(cur != null){
            cur = cur.next;
            len ++;
        }
        if(n > len) return head;

        ListNode dummy = new ListNode(0, head);
        cur = dummy;

        for(int i = 0; i < len - n; i++){
            cur = cur.next;
        }
        if(cur.next != null){
            cur.next = cur.next.next;
        }
        return dummy.next;

    }

}
