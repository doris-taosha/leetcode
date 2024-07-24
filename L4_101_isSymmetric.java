package top150;


import java.util.*;

/**
 *101. 对称树

 * 给定root一棵二叉树，检查它是否是其自身的镜像（即，围绕其中心对称）。
 *
 * 输入： root = [1,2,2,3,4,4,3]
 * 输出： true
 *
 * 输入： root = [1,2,2,null,3,null,3]
 * 输出： false
 */
public class L4_101_isSymmetric {



    //迭代法
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> ques = new LinkedList<>();
        ques.offer(root.left);
        ques.offer(root.right);
        while(!ques.isEmpty()){
            TreeNode ll = ques.poll();
            TreeNode rr = ques.poll();
            if(ll == null && rr == null) continue;  //两个节点都为空则继续
            //否则其中有一个节点不为空、或两个节点的值不相等
            if(ll == null || rr == null || ll.val != rr.val) return false;

            ques.offer(ll.left);
            ques.offer(rr.right);
            ques.offer(ll.right);
            ques.offer(rr.left);
        }
        return true;
    }


    //递归法
    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null)  return true;
        if(left == null || right == null || left.val != right.val) return false;

        Boolean out = helper(left.left, right.right);
        Boolean in  = helper(left.right, right.left);
        return in && out;

    }

}
