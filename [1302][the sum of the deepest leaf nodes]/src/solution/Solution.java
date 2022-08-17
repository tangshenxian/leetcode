package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 1302. 层数最深叶子节点的和
 *
 * @author: shenxian
 * @date: 2022/8/17 9:40
 */
public class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int max;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return map.get(max);
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        max = Math.max(max, depth);
        map.put(depth, map.getOrDefault(depth, 0) + root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
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
