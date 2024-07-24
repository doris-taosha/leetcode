package top150;


import java.util.LinkedList;
import java.util.*;

/**
 *100. 同一棵树
 * 给定两个二叉树的根p和q，编写一个函数来检查它们是否相同。
 *
 * 如果两棵二叉树结构相同，且节点具有相同的值，则认为它们相同。
 *
 *
 * 示例 1：
 * 输入： p = [1,2,3], q = [1,2,3]
 * 输出： true
 *
 *示例 2：
 * 输入： p = [1,2], q = [1,null,2]
 * 输出： false
 *
 * 示例 3：
 * 输入： p = [1,2,1], q = [1,1,2]
 * 输出： false
 *
 */
public class L2_100_isSameTree {



    //层次遍历

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> ques = new LinkedList<>();
        ques.offer(p);
        ques.offer(q);
        while(!ques.isEmpty()){
            TreeNode node1 = ques.poll();
            TreeNode node2 = ques.poll();
            if(node1 == null && node2 == null) continue;
            if(node1== null || node2 == null || node1.val != node2.val) return false;

            ques.offer(node1.left);
            ques.offer(node2.left);
            ques.offer(node1.right);
            ques.offer(node2.right);
        }
        return true;

    }


    //递归
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        boolean leftJudgr = isSameTree(p.left, q.left);
        boolean rightJudgr = isSameTree(p.right, q.right);

        return leftJudgr && rightJudgr;

    }



}
