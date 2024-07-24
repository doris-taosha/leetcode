package top150;

/**
 * 给定一个正整数数组和一个nums正整数target，返回
 * 子阵列其和大于或等于 target。如果不存在这样的子数组，0则返回。
 *
 *
 * 示例 1：
 * 输入： target = 7, nums = [2,3,1,2,4,3]
 * 输出： 2
 * 解释：子数组 [4,3] 在问题约束下具有最小长度。
 *
 *
 * 示例 2：
 * 输入： target = 4, nums = [1,4,4]
 * 输出： 1
 *
 *
 * 示例 3：
 * 输入： target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出： 0
 */

public class C1_209_minSubArrayLen {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1,1,1}));


    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        if(nums.length == 0) return 0;

        int left = 0, right = 0, sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while(sum >= target ){
                minLen = Math.min(minLen, (right - left + 1));
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

}
