package top150;


import java.util.Stack;

/***
 *
 * 112. 路径和
 * 给定root一棵二叉树和一个整数targetSum，返回true该树是否具有从根到叶的路径，并且将路径上的所有值相加等于targetSum。
 *
 * 叶子节点是没有子节点的节点。
 *
 * 示例 1：
 * 输入： root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出： true
 * 解释：显示具有目标和的根到叶路径。
 *
 * 示例 2：
 * 输入： root = [1,2,3], targetSum = 5
 * 输出： false
 * 解释：树中有两条从根到叶的路径：
 * (1 --> 2)：总和为 3。
 * (1 --> 3)：总数为 4。
 * 不存在总和 = 5 的从根到叶的路径。
 *
 *
 * 示例 3：
 * 输入： root = [], targetSum = 0
 * 输出： false
 * 解释：由于树是空的，所以没有从根到叶的路径。
 */
public class L9_112_hasPathSum {


    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root == null) return false;
        Stack<TreeNode> stacks = new Stack<>();
        Stack<Integer> sumStacks = new Stack<>();
        stacks.push(root);
        sumStacks.push(root.val);
        while(!stacks.isEmpty()) {
            TreeNode node = stacks.pop();
            Integer sum = sumStacks.pop();
            if (node.left == null && node.right == null && sum == targetSum) return true;
            if (node.right != null) {
                stacks.push(node.right);
                sumStacks.push(sum + node.right.val);
            }

            if (node.left != null) {
                stacks.push(node.left);
                sumStacks.push(sum + node.left.val);
            }
        }
        return true;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null && root.val == targetSum) return true;

        boolean ll = hasPathSum2(root.left, targetSum - root.val);
        boolean rr = hasPathSum2(root.right, targetSum - root.val);
        return ll || rr;

    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if( root == null ) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) return true;

        if(root.left != null){
            boolean ll = hasPathSum(root.left, targetSum);
            if(ll) return true;
        }
        if(root.right != null){
            boolean rr = hasPathSum(root.right, targetSum);
            if(rr) return true;
        }
        return false;
    }
}
