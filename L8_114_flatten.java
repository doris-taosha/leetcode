package top150;


/**
 * 114. 将二叉树展平为链表

 * 给定root二叉树的，将树展平为“链表”：
 *
 * “链表”应该使用相同的TreeNode类，其中right子指针指向列表中的下一个节点，并且left子指针始终为null。
 * “链表”的顺序应该与二叉树的先序遍历相同。
 */
public class L8_114_flatten {

        public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                //如果当前左节点不为空，就找到左侧最后一个叶子节点
                TreeNode runner = cur.left; //找到节点的最右边节点
                while(runner.right != null){
                    runner = runner.right;
                }
                //将当前节点的右侧节点切到此节点的右边，并将左侧节点置空
                runner.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }

            //将当前节点的右节点，放到
            cur = cur.right;
        }
    }

}
