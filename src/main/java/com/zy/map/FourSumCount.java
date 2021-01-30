package com.zy.map;

import org.junit.Test;

import java.util.*;

/**
 * 454. 四数相加 II
 * <p>
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class FourSumCount {

    @Test
    public void test() {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println(fourSumCount(a, b, c, d));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int key = A[i] + B[j];
                Integer val = map.get(key);
                if (val == null) {
                    val = 0;
                }
                map.put(key, ++val);
            }
        }

        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int key = 0 - C[i] - D[j];
                Integer val = map.get(key);
                if (val != null) {
                    count += val;
                }
            }
        }

        return count;
    }

    @Test
    public void testFourSum() {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {0, 0, 0, 0, 0};
        int target = 0;
        long start = System.currentTimeMillis();
        for (List<Integer> list : fourSum(nums, target)) {
            System.out.println(list);
        }
        System.out.println("takes " + (System.currentTimeMillis() - start) + " mills");
    }
    @Test
    public void testFourSum2() {
        int[] nums = {0, 4, -5, 2, -2, 4, 2, -1, 4};
        int target = 12;
        long start = System.currentTimeMillis();
        for (List<Integer> list : fourSum(nums, target)) {
            System.out.println(list);
        }
        System.out.println("takes " + (System.currentTimeMillis() - start) + " mills");
    }
    @Test
    public void testFourSum3() {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        long start = System.currentTimeMillis();
        for (List<Integer> list : fourSum(nums, target)) {
            System.out.println(list);
        }
        System.out.println("takes " + (System.currentTimeMillis() - start) + " mills");
    }
    @Test
    public void testFourSum4() {
        int[] nums = {-1,-3,-2,2,3,-3,0,-4};
        int target = 4;
        long start = System.currentTimeMillis();
        for (List<Integer> list : fourSum(nums, target)) {
            System.out.println(list);
        }
        System.out.println("takes " + (System.currentTimeMillis() - start) + " mills");
    }

    /**
     * 18. 四数之和
     *
     * 示例：
     *
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
//            if (nums[i] > target) {
//                return result;
//            }
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while (left < right && (nums[left] == nums[left + 1])) {
                            left++;
                        }
                        while (left < right && (nums[right] == nums[right - 1])) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
                while (j < nums.length - 1 && (nums[j] == nums[j + 1])) {
                    j++;
                }
            }
        }
        return result;
    }


    @Test
    public void testThreeSum() {
        Tuple3 t1 = new Tuple3(1,2,1);
        Tuple3 t2 = new Tuple3(1,2,1);
        System.out.println(t1.hashCode() == t2.hashCode());
        System.out.println(t1.equals(t2));
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0, 0, 0, 0, 0};
//        int[] nums = {7,-10,7,3,14,3,-2,-15,7,-1,-7,6,-5,-1,3,-13,6,-15,-10,14,8,5,-10,-1,1,1,11,6,8,5,-4,0,3,10,-12,-6,-2,-6,-6,-10,8,-5,12,10,1,-8,4,-8,-8,2,-9,-15,14,-11,-1,-8,5,-13,14,-2,0,-13,14,-12,12,-13,-3,-13,-12,-2,-15,4,8,4,-1,-6,11,11,-7,-12,-2,-8,10,-3,-4,-6,4,-14,-12,-5,0,3,-3,-9,-2,-6,-15,2,-11,-11,8,-11,8,-7,8,14,-5,4,10,3,-1,-15,10,-6,-11,13,-5,1,-15};
        long start = System.currentTimeMillis();
        for (List<Integer> list : threeSum(nums)) {
            System.out.println(list);
        }
        System.out.println("takes " + (System.currentTimeMillis() - start) + " mills");
        start = System.currentTimeMillis();
        for (List<Integer> list : threeSum2(nums)) {
            System.out.println(list);
        }
        System.out.println("takes " + (System.currentTimeMillis() - start) + " mills");
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left < right && (nums[left] == nums[left + 1])) {
                        left++;
                    }
                    while (left < right && (nums[right] == nums[right - 1])) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * 15. 三数之和
     * <p>
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Tuple2>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                List<Tuple2> val = map.get(key);
                if (val == null) {
                    val = new ArrayList<>();
                }
                val.add(new Tuple2(i, j));
                map.put(key, val);
            }
        }

        Set<Tuple3> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Tuple2> val = map.get(0 - nums[i]);
            if (val != null) {
                for (Tuple2 tuple2 : val) {
                    if (i != tuple2.x && i != tuple2.y) {
                        Tuple3 tuple3 = new Tuple3(tuple2.x, tuple2.y, i);
                        set.add(tuple3);
                    }
                }
            }
        }

        Set<Tuple3> set2 = new HashSet<>();
        for (Tuple3 tuple3 : set) {
            set2.add(new Tuple3(nums[tuple3.x], nums[tuple3.y], nums[tuple3.z]));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Tuple3 tuple3 : set2) {
            List<Integer> l = new ArrayList<>();
            l.add(tuple3.x);
            l.add(tuple3.y);
            l.add(tuple3.z);
            result.add(l);
        }
        return result;
    }

    class Tuple2 {
        public int x;
        public int y;
        public Tuple2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Tuple3 {
        public int x;
        public int y;
        public int z;
        public Tuple3(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + x + y + z;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (! (obj instanceof Tuple3)) {
                return false;
            }

            Tuple3 o = (Tuple3) obj;

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(this.x, 1);
            if (map.get(this.y) == null) {
                map.put(this.y, 1);
            } else {
                map.put(this.y, map.get(this.y) + 1);
            }
            if (map.get(this.z) == null) {
                map.put(this.z, 1);
            } else {
                map.put(this.z, map.get(this.z) + 1);
            }

            if (map.get(o.x) != null) {
                map.put(o.x, map.get(o.x) - 1);
            } else {
                return false;
            }

            if (map.get(o.y) != null) {
                map.put(o.y, map.get(o.y) - 1);
            } else {
                return false;
            }

            if (map.get(o.z) != null) {
                map.put(o.z, map.get(o.z) - 1);
            } else {
                return false;
            }

            for (Integer value : map.values()) {
                if (value != 0) {
                    return false;
                }
            }

            return true;
        }
    }

}
