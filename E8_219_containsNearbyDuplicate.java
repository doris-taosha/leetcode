package top150;
import java.util.*;

/**
 *219. 包含重复 II
 * 给定一个整数数组nums和一个整数k，返回数组中 是否存在两个不同的索引 i和j，使得nums[i] == nums[j] and abs(i - j) <= k.
 *
 * 示例 1：
 *
 * 输入： nums = [1,2,3,1], k = 3
 * 输出： true
 *
 *
 * 示例 2：
 * 输入： nums = [1,0,1,1], k = 1
 * 输出： true
 *
 * 示例 3：
 * 输入： nums = [1,2,3,1,2,3], k = 2
 * 输出： false
 */

public class E8_219_containsNearbyDuplicate {

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums.length == 1)  return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int gap = Math.abs(i - map.get(nums[i]));
                if(gap <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
