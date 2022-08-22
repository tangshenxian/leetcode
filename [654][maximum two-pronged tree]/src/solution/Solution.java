package solution;

/**
 * 654. 最大二叉树
 *
 * @author: shenxian
 * @date: 2022/8/22 15:20
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 从nums下标[l, r]中构建，返回root
     *
     * @param nums /
     * @param l    /
     * @param r    /
     */
    private TreeNode build(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int index = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = build(nums, l, index - 1);
        root.right = build(nums, index + 1, r);
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
