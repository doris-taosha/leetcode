package top150;


/**
 * 141. 链表循环
 * 给定head一个链表的头，确定该链表中是否存在循环。
 *
 * 如果链表中有某个节点可以通过连续跟随指针再次到达 next ，则链表中存在循环。在内部，pos 用于表示 tail next 指针所连接的节点的索引。 请注意， pos 不作为参数传递。
 * 如果链表有循环则返回true ，否则返回false。
 *
 *
 * 示例 1：
 * 输入： head = [3,2,0,-4], pos = 1
 * 输出： true
 * 解释：链表中有一个循环，其中尾部连接到第 1 个节点（0 索引）。
 *
 *
 * 示例 2：
 * 输入： head = [1,2], pos = 0
 * 输出： true
 * 解释：链表中有一个循环，其尾部连接到第 0 个节点。
 *
 * 示例 3：
 * 输入： head = [1], pos = -1
 * 输出： false
 * 解释：链表中没有循环。
 */

public class H1_141_hasCycle {


    /**
     * 解决单链表中检测循环问题的主要思想是使用两个指针的概念：
     * 一个“慢速”指针，每次移动一步，一个“快速”指针，每次移动两步。
     * 通过让这两个指针同时遍历列表，如果有循环，快速指针最终会赶上慢速指针。如果没有循环，快速指针将到达列表的末尾。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
