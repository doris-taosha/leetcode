package top150;

import java.util.*;

/**
 *1. 两数之和
 *
 * 给定一个整数数组nums 和一个整数target，返回两个数字的索引，使得它们加起来等于target。
 * 您可以假设每个输入只有一个解决方案，并且可能不会两次使用相同的元素。
 *
 * 您可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入： nums = [2,7,11,15], target = 9
 * 输出： [0,1]
 * 解释：因为 nums[0] + nums[1] == 9，所以我们返回 [0, 1]。
 *
 * 示例 2：
 * 输入： nums = [3,2,4], target = 6
 * 输出： [1,2]
 *
 * 示例 3：
 * 输入： nums = [3,3], target = 6
 * 输出： [0,1]
 *
 */


public class E6_1_twoSum {

    //暴力法---两遍循环
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff))return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
