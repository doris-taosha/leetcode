package top150;

import java.util.*;

/**
 *
 * 给定root一棵二叉树，其中仅包含从0到的数字9。
 *
 * 树中每条从根到叶的路径代表一个数字。
 *
 * 例如，从根到叶的路径1 -> 2 -> 3表示数字123。
 * 返回所有根到叶数字的总和。测试用例的生成使得答案适合32 位整数。
 *
 * 叶节点是没有子节点的节点。
 *
 *
 *输入： root = [1,2,3]
 * 输出： 25
 * 解释：
 * 从根到叶的路径1->2表示数字12。
 * 从根到叶的路径1->3代表数字13。
 * 因此，总和 = 12 + 13 = 25。
 *
 *
 * 输入： root = [4,9,0,5,1]
 * 输出： 1026
 * 解释：
 * 从根到叶的路径4->9->5代表数字 495。
 * 从根到叶的路径4->9->1代表数字 491。
 * 从根到叶的路径4->0代表数字 40。
 * 因此，总和 = 495 + 491 + 40 = 1026。
 *
 */
public class L10_129_sumNumbers {

    public int sumNumbers2(TreeNode root) {
        if(root == null)  return 0;
        return dfs(root, 0);
    }


    public int dfs(TreeNode node, int num) {
        if(node == null) return 0;
        num = num * 10 + node.val;
        if(node.left == null && node.right == null) return num;

        return dfs(node.left, num) + dfs(node.right, num);


    }

    public int sumNumbers1(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Stack<TreeNode> stacks = new Stack<>();
        Stack<Integer> sumStacks = new Stack<>();

        stacks.push(root);
        sumStacks.push(root.val);

        while (!stacks.isEmpty()) {
            TreeNode node = stacks.pop();
            Integer sum = sumStacks.pop();

            if (node.left == null && node.right == null) {
                res += sum;
            }
            if (node.right != null) {
                stacks.push(node.right);
                sumStacks.push(sum * 10 + node.right.val);
            }
            if (node.left != null) {
                stacks.push(node.left);
                sumStacks.push(sum * 10 + node.left.val);
            }
        }
        return res;
    }


    public int sumNumbers(TreeNode root) {

        if(root == null) return 0;
        List<Integer> pass = new ArrayList<Integer>();
        helper(root, pass, root.val);
        int res = 0;
        for(int i = 0; i < pass.size(); i++){
            res += pass.get(i);
        }
        return res;

    }
    public void helper(TreeNode node, List<Integer> path, int sum){
        if(node.left == null && node.right == null) {
            path.add(sum);
        }
        int newSum = 0;
        if(node.left != null){
            newSum = sum * 10 + node.left.val;
            helper(node.left, path, newSum);
        }
        if(node.right != null){
            newSum = sum * 10 + node.right.val;
            helper(node.right, path, newSum);
        }
    }
}
