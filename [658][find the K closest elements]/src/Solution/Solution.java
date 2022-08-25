package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 *
 * @author: shenxian
 * @date: 2022/8/25 10:25
 */
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        // 二分查找与x最相近的元素下标
        int idx = binarySearch(arr, x);
        int l = idx - 1, r = idx + 1;
        while (r - l - 1 < k) {
            if (l >= 0 && r < n) {
                if (Math.abs(arr[r] - x) < Math.abs(arr[l] - x)) {
                    r++;
                } else {
                    l--;
                }
            } else if (l >= 0) {
                l--;
            } else {
                r++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l + 1; i <= r - 1; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private int binarySearch(int[] arr, int x) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r + 1 < n && Math.abs(arr[r + 1] - x) < Math.abs(arr[r] - x) ? r + 1 : r;
    }

}
