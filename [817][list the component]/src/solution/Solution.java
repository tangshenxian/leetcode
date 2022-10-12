package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 *
 * @author: shenxian
 * @date: 2022/10/12 9:27
 */
public class Solution {

    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (head != null) {
            if (set.contains(head.val)) {
                while (head != null && set.contains(head.val)) {
                    head = head.next;
                }
                ans++;
            } else {
                head = head.next;
            }
        }
        return ans;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}