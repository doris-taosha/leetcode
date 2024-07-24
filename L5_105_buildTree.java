package top150;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * 105. 根据前序和中序遍历构造二叉树

 * 给定两个整数数组preorder和，inorder其中preorder是二叉树的前序遍历，inorder是同一棵树的中序遍历，构造并返回二叉树。
 *
 * 示例 1：
 * 输入： preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出： [3,9,20,null,null,15,7]
 *
 * 示例 2：
 * 输入： preorder = [-1], inorder = [-1]
 * 输出： [-1]
 */
public class L5_105_buildTree {

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }


    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd ) return null;
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        int cutRoot = map.get(val);
        int len = cutRoot - inStart;
        TreeNode leftNode = helper(preorder, preStart + 1, preStart + len, inorder, inStart, cutRoot - 1);
        TreeNode rightNode = helper(preorder, preStart + 1 + len , preEnd, inorder, cutRoot + 1, inEnd);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
}
