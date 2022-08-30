package solution;

/**
 * 998. 最大二叉树 II
 *
 * @author: shenxian
 * @date: 2022/8/30 14:59
 */
public class Solution {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode pre = null, cur = root;
        while (cur != null && cur.val > val) {
            pre = cur;
            cur = cur.right;
        }
        if (pre == null) {
            node.left = cur;
            return node;
        }
        pre.right = node;
        node.left = cur;
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
