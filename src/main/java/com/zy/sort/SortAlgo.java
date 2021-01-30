package com.zy.sort;

import java.util.*;

public class SortAlgo {

    public static void main(String[] args) {
//        testMergeSort();
//        testSelectSort();

//        testIntersection();

        int[] idx = new int[1001];
        System.out.println(idx[3]);
        System.out.println(idx[2]);
        System.out.println(idx[4]);
    }

    /**
     * 选择排序
     */
    public static void testSelectSort() {
        int[] ints = {2,5,3,6,7};
        selectSort(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static void selectSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int curr = ints[i];
            int j = i-1;
            for (; j > 0; j--) {
                if (ints[i] < ints[j]) {
                    ints[j+1] = ints[j];
                } else {
                    break;
                }
            }
            ints[j+1] = curr;
        }
    }

    /**
     * 归并排序
     */
    public static void testMergeSort() {
        int[] ints = {2,5,3,6,7};
        mergeSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
    public static void mergeSort(int[] ints, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort(ints, low, mid);
            // 右边
            mergeSort(ints, mid + 1, high);
            // 左右归并
            merge(ints, low, mid, high);
            System.out.println(Arrays.toString(ints));
        }
    }
    private static void merge(int[] ints, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (ints[i] < ints[j]) {
                temp[k++] = ints[i++];
            } else {
                temp[k++] = ints[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = ints[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = ints[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            ints[k2 + low] = temp[k2];
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }
    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (temp >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = temp;
        return left;
    }

    /**
     * 349. 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     */
    public static void testIntersection() {
        int[] i1 = {1, 2, 2, 1};
        int[] i2 = {1, 2};
        int[] rst = intersection(i1, i2);
        System.out.println(Arrays.toString(rst));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }

        int[] rst = new int[set.size()];
        Iterator iterator = set.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            rst[idx++] = (int) iterator.next();
        }

        return rst;
    }

    /**
     * 56. 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        // 增序排序
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int j = i -1;
            for (; j >= 0; j--) {
                if (curr[0] < intervals[j][0]) {
                    intervals[j+1] = intervals[j];
                } else {
                    break;
                }
            }
            intervals[j+1] = curr;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int flagIdx = 0;
            int j = i+1;
            for (; j < intervals.length; j++) {
                // 左边界交换
                if (intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = intervals[i][0];
                    // 右边界交换
                    if (intervals[i][1] > intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    i = j;
                    flagIdx = j;
                }
            }
            if (flagIdx > 0 && flagIdx < intervals.length) {
                list.add(intervals[flagIdx]);
            } else {
                list.add(intervals[i]);
            }
        }

        // // 删除重复数据
        // for (int i = 0; i < list.size()-1; i++) {
        //     for (int j = i+1; j < list.size(); j++) {
        //         int[] i1 = list.get(i);
        //         int[] i2 = list.get(j);
        //         if (i1[0] == i2[0] && i1[1] == i2[1]) {
        //             list.remove(j);
        //             j--;
        //         }
        //     }
        // }

        return list.toArray(new int[0][0]);
    }

    /**
     * 242. 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        // 如果输入字符串包含 unicode 字符，使用 hashmap 替换 int[]，但如果是超过 65535 的字符(一个字符对应两个 char，暂未想好如何处理)
        int[] alphabet = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            alphabet[charS[i] - 'a']++;
            alphabet[charT[i] - 'a']--;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 147. 对链表进行插入排序
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode cursor = dumy;
        ListNode curr = head;

        while (curr != null) {
            while (cursor != curr &&
                    (curr.next == null || curr.next.val >= cursor.next.val)) {
                cursor = cursor.next;
            }
            if (cursor != curr) {
                //删除curr.next节点
                ListNode tmp = curr.next;
                curr.next = curr.next.next;
                //将curr.next节点插入cursor节点后面
                tmp.next = cursor.next;
                cursor.next = tmp;
            } else {
                curr = curr.next;
            }

            cursor = dumy;
        }

        return dumy.next;

//        // 定义三个指针 pre, cur, lat
//        //pre    cur    lat
//        // h  ->  4  ->  2  ->  5  ->  3  ->  null
//
//        // 创建 h 节点，用于遍历链表
//        ListNode h = new ListNode(0);
//        h.next = head;
//        ListNode pre = h;
//        ListNode cur = head;
//        ListNode lat;
//
//        while (cur != null) {
//            lat = cur.next; // 记录下一个要插入排序的值
//            // 由于每次都是从前往后找插入位置，但是单向链表是无法从后往前遍历，所以需要每次插入完成后要让 pre 复位
//            pre = h;
//
//            if (lat != null && lat.val < cur.val) { // 只有 cur.next 比 cur 小才需要向前寻找插入点
//                // 寻找插入点，从 pre 开始遍历 （每次都是头节点 h 开始向后遍历，因为单向链表是无法从后往前遍）
//                while (pre.next != null && pre.next.val < lat.val) { // 如果当前节点的值小于要插入排序的值
//                    pre = pre.next; // 继续向后移动
//                }
//
//                // 找到要插入的位置，此时 pre 节点后面的位置就是 lat 要插入的位置
//                // 交换 pre 跟 lat 节点需要一个 temp 节点来临时保存下插入位置 node 后 next
//                ListNode tmp = pre.next;
//                // 在 pre 节点后面插入
//                pre.next = lat;
//                // 此时 cur 节点还是 pre 所在的节点，所以其 next 要指向插入节点 lat 指向的 next
//                cur.next = lat.next;
//                // 插入let节点后，把记录的原先插入位置后续的 next 节点传给它
//                lat.next = tmp;
//            } else {
//                // 都这直接把 cur 指针指向到下一个
//                cur = lat;
//            }
//        }
//
//        return h.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 922. 按奇偶排序数组 II
     *
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     */
    public int[] sortArrayByParityII(int[] A) {
        if ((A.length & 2) == 1) {
            throw new IllegalArgumentException("说好了奇偶数各对半分的");
        }
        int even = 0, odd = 1;
        int maxIdx = A.length - 1;
        while (odd <= maxIdx) {
            // if ((A[odd] & 1) == 1) {
            //     odd += 2;
            // } else {
            //     if ((A[even] & 1) == 0) {
            //         even += 2;
            //     } else {
            //         // swap
            //         int tmp = A[odd];
            //         A[odd] = A[even];
            //         A[even] = tmp;
            //         odd += 2;
            //         even += 2;
            //     }
            // }

            if ((A[odd] & 1) == 0) {
                if ((A[even] & 1) == 1) {
                    // swap
                    int tmp = A[odd];
                    A[odd] = A[even];
                    A[even] = tmp;
                    odd += 2;
                    even += 2;
                } else {
                    even += 2;
                }
            } else {
                odd += 2;
            }
        }
        return A;
    }

    /**
     * 153. 寻找旋转排序数组中的最小值
     *
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 请找出其中最小的元素。
     *
     * 你可以假设数组中不存在重复元素。
     */
    public int findMin(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        // 最小元素比它前一个元素小，并且比它后一个元素小
        if (nums[0] < nums[1] && nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int maxIdx = nums.length - 1;
        for (int i = 1; i < maxIdx; i++) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[maxIdx];
    }

    /**
     * 1122. 数组的相对排序
     *
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] idx = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            idx[arr1[i]]++;
        }
        int ix = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < idx[arr2[i]]; j++) {
                arr1[ix++] = arr2[i];
            }
            idx[arr2[i]] = 0;
        }
        // idx中不为0的idx插入arr1
        for (int i = 0; i < idx.length; i++) {
            for (int j = 0; j < idx[i]; j++) {
                arr1[ix++] = i;
            }
            // idx[i] = 0;
        }
        return arr1;
    }

    public int majorityElement(int[] nums) {
        int tmpSum = 0;
        int tmpMode = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (tmpSum == 0) {
                tmpMode = nums[i];
            }
            if (nums[i] == tmpMode) {
                tmpSum += 1;
            } else {
                tmpSum += -1;
            }
        }
        return tmpMode;
    }

}
