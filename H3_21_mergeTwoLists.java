package top150;


import static javafx.scene.input.KeyCode.L;

/***
 * 21. 合并两个排序列表
 *
 * 给出了两个已排序链表的头list1和list2。
 * 将两个列表合并为一个排序列表。该列表应通过将前两个列表的节点拼接在一起而制成。
 *
 * 返回合并链表的头。
 *
 * 示例 1：
 * 输入： list1 = [1,2,4], list2 = [1,3,4]
 * 输出： [1,1,2,3,4,4]
 *
 *
 * 示例 2：
 * 输入： list1 = [], list2 = []
 * 输出： []
 *
 *
 * 示例 3：
 * 输入： list1 = [], list2 = [0]
 * 输出： [0]
 */


public class H3_21_mergeTwoLists {
    public ListNode  mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummpHead = new ListNode(0);
        ListNode cur = dummpHead;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null ) ? list1 : list2;
        return dummpHead.next;
    }


    public ListNode  mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummpHead = new ListNode(0);
        ListNode cur = dummpHead;
        while(list1 != null && list2 != null){
            ListNode newNode = new ListNode();
            if(list1.val < list2.val){
                newNode.val = list1.val;
                list1 = list1.next;
            }else{
                newNode.val = list2.val;
                list2 = list2.next;
            }
            cur.next = newNode;
            cur = cur.next;
        }

        while(list1 != null){
            ListNode newNode = new ListNode(list1.val);
            cur.next = newNode;
            list1 = list1.next;
            cur = cur.next;
        }
        while(list2 != null){
            ListNode newNode = new ListNode(list2.val);
            cur.next = newNode;
            cur = cur.next;
            list2 = list2.next;
        }

        return dummpHead.next;
    }

}
