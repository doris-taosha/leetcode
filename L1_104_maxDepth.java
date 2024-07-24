package top150;


import java.util.*;

/***
 * 104. 二叉树的最大深度
 *
 * 给定root一棵二叉树的，返回其最大深度。
 *
 * 二叉树的最大深度 是从根节点到最远叶节点的最长路径上的节点数。
 *
 *
 * 示例 1：
 * 输入： root = [3,9,20,null,null,15,7]
 * 输出： 3
 *
 * 示例 2：
 * 输入： root = [1,null,2]
 * 输出： 2
 */
public class L1_104_maxDepth {

    int res;
    public int maxDepth2(TreeNode root) {
        res = 0;

        if(root == null) return res;
        getDepth(root, 1);
        return res;
    }

    //前序遍历
    public void getDepth(TreeNode node, int depth){
        res = depth > res ? depth : res;
        if(node.left == null && node.right == null)  return ;
        if(node.left != null ) getDepth(node.left, depth+1);
        if(node.right != null ) getDepth(node.right, depth + 1);
        return;
    }


    //后序遍历
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftD = maxDepth(root.left); //左
        int rightD = maxDepth(root.right); // 右
        int depth = Math.max(leftD, rightD) + 1; //中
        return depth;
    }


    //层次遍历
    public int maxDepth1(TreeNode root) {
        //层次遍历
        if(root == null) return 0;
        Queue<TreeNode> ques = new LinkedList<>();
        ques.offer(root);
        int level =  0;
        while(!ques.isEmpty()){
            level ++;
            int size = ques.size();
            for(int i = 0; i < size; i++){
                TreeNode node = ques.poll();
                if(node.left != null) ques.offer(node.left);
                if(node.right != null) ques.offer(node.right);
            }
        }
        return level;

    }
}