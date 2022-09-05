package solution;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 *
 * @author: shenxian
 * @date: 2022/9/5 10:03
 */
public class Solution {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    String dfs(TreeNode root) {
        if (root == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            ans.add(root);
        }
        return key;
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