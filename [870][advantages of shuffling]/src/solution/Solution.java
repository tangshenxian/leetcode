package solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 870. 优势洗牌
 *
 * @author: shenxian
 * @date: 2022/10/8 9:43
 */
public class Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx2[i] = i;
        }
        Arrays.sort(idx2, Comparator.comparingInt(i -> nums2[i]));

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            int val = nums1[i];
            if (val > nums2[idx2[left]]) {
                ans[idx2[left]] = val;
                left++;
            } else {
                ans[idx2[right]] = val;
                right--;
            }
        }
        return ans;
    }

}
