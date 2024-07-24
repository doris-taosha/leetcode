package top150;

import java.util.*;

/***
 *
 *226. 反转二叉树
 *
 * 给定root一棵二叉树的，反转该树，并返回其根。
 *
 *输入： root = [4,2,7,1,3,6,9]
 * 输出： [4,7,2,9,6,3,1]
 *
 *
 * 输入： root = [2,1,3]
 * 输出： [2,3,1]
 * 示例 3：
 *
 * 输入： root = []
 * 输出： []
 *
 */

public class L3_226_invertTree {


    //广度遍历--层次遍历
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> ques  = new LinkedList<>();
        ques.offer(root);

        while(!ques.isEmpty()){
            int size = ques.size();
            for(int i = 0; i < size; i++){
                TreeNode node = ques.poll();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if(node.left != null) ques.offer(node.left);
                if(node.right != null) ques.offer(node.right);
            }
        }
        return root;

    }

        //深度遍历--迭代法
    public TreeNode invertTree1(TreeNode root) {
        if(root == null) return root;

        Stack<TreeNode> stacks = new Stack<>();
        stacks.push(root);
        while(!stacks.isEmpty()){
            TreeNode node = stacks.pop();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.right != null) stacks.push(node.right);
            if(node.left != null) stacks.push(node.left);
        }
        return root;

    }


    //前序遍历 --递归
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        //交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;


    }
}
