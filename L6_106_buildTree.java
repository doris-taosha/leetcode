package top150;
import java.util.*;

/***
 *
 *
 * 106. 根据中序和后序遍历构造二叉树
 * 给定两个整数数组inorder和，postorder其中inorder是二叉树的中序遍历，postorder是同一棵树的后序遍历，构造并返回二叉树。
 *
 * 输入：中序 = [9,3,15,20,7]，后序 = [9,15,7,20,3]
 * 输出： [3,9,20,null,null,15,7]
 *
 *
 * 示例 2：
 * 输入：中序 = [-1]，后序 = [-1]
 * 输出： [-1]
 */
public class L6_106_buildTree {

    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd,  int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return null;
        int cutIndex = map.get(postorder[postEnd]);
        TreeNode node = new TreeNode(postorder[postEnd]);
        int len = cutIndex - inStart;
        TreeNode left = helper(inorder, inStart, cutIndex - 1, postorder, postStart, postStart + len - 1);
        TreeNode right = helper(inorder, cutIndex + 1, inEnd, postorder, postStart + len , postEnd - 1);
        node.left = left;
        node.right = right;
        return node;
    }

}
