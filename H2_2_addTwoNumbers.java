package top150;

import java.util.List;

/**
 *
 * 2. 将两个数字相加
 * 给定两个非空链表，分别表示两个非负整数。数字以相反的顺序存储，每个节点都包含一位数字。将两个数字相加，并以链表形式返回总和。
 *
 * 您可以假设这两个数字不包含任何前导零，除了数字 0 本身。
 *
 * 示例 1：
 * 输入： l1 = [2,4,3], l2 = [5,6,4]
 * 输出： [7,0,8]
 * 解释： 342 + 465 = 807。
 *
 * 示例 2：
 * 输入： l1 = [0],l2 = [0]
 * 输出： [0]
 *
 * 示例 3：
 * 输入： l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出： [8,9,9,9,0,0,0,1]
 */

public class H2_2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummpHead = new ListNode(0);
        ListNode cur = dummpHead;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0 ){
            int digital1 = ( l1 != null ) ? l1.val : 0;
            int digital2 = ( l2 != null ) ? l2.val : 0;

            int sum = digital1 + digital2 + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode( sum % 10);
            cur.next = newNode;
            cur = cur.next;

            l1 = (l1 != null ) ? l1.next : null;
            l2 = (l2 != null ) ? l2.next : null;
        }
        return dummpHead.next;
    }

}
