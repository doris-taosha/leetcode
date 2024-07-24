package top150;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 117. 在每个节点中填充下一个右指针 II
 *填充每个下一个指针以指向其下一个右节点。如果没有下一个右节点，则下一个指针应设置为NULL。
 *
 * 最初，所有 next 指针都设置为NULL。
 *
 */
public class L7_117_connect {


    public TNode connect1(TNode root) {
        if(root == null) return null;
        Queue<TNode> ques = new LinkedList<>();
        ques.offer(root);

        while(!ques.isEmpty()){
            int size = ques.size();
            TNode prev = null;
            for(int i = 0; i < size; i++){
                TNode cur = ques.poll();
                if(prev != null) prev.next = cur;

                prev = cur;
                if(cur.left != null) ques.offer(cur.left);
                if(cur.right != null) ques.offer(cur.right);
            }
            prev.next = null;
        }
        return root;

    }
    public TNode connect(TNode root) {
        if(root == null) return null;
        Queue<TNode> ques = new LinkedList<>();
        ques.offer(root);

        while(!ques.isEmpty()){
            int size = ques.size();
            TNode pre = null;
            TNode cur = null;
            for(int i = 0; i < size; i++){
                if(i == 0){
                    pre = ques.poll();
                    cur = pre;
                }else{
                    cur = ques.poll();
                    pre.next = cur;
                    pre = pre.next;
                }

                if(cur.left != null) ques.offer(cur.left);
                if(cur.right != null) ques.offer(cur.right);

            }
            pre.next = null;
        }
        return root;





    }
}
