package top150;

public class ListNode {
    int val;

    ListNode next;

    ListNode() {}

    ListNode(int x){
        this.val = x;
        this.next = null;
    }

    ListNode(int x, ListNode next){
        this.val = x;
        this.next = next;
    }
}
