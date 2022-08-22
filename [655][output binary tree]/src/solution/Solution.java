package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. 输出二叉树
 *
 * @author: shenxian
 * @date: 2022/8/22 14:58
 */
public class Solution {

    int height, m, n;
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        dfs1(root, 0);
        m = height + 1;
        n = (1 << (height + 1)) - 1;
        for (int i = 0; i < m; i++) {
            List<String> arr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                arr.add("");
            }
            result.add(arr);
        }
        dfs2(root, 0, (n - 1) / 2);
        return result;
    }

    /**
     * 获取树的高度
     */
    void dfs1(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        height = Math.max(height, depth);
        dfs1(root.left, depth + 1);
        dfs1(root.right, depth + 1);
    }

    void dfs2(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        result.get(x).set(y, String.valueOf(root.val));
        dfs2(root.left, x + 1, y - (1 << (height - x - 1)));
        dfs2(root.right, x + 1, y + (1 << (height - x - 1)));
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
