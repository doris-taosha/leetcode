package top150;

import java.util.*;

/**
 *
 * 128. 最长连续序列
 * 给定一个未排序的整数数组nums，返回最长连续元素序列的长度。
 * 您必须编写一个能及时运行的算法 O(n) 。
 *
 *
 *
 * 示例 1：
 * 输入： nums = [100,4,200,1,3,2]
 * 输出： 4
 * 解释：最长连续元素序列是[1, 2, 3, 4]。因此它的长度为 4。
 *
 *
 * 示例 2：
 * 输入： nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出： 9
 */

public class E9_128_longestConsecutive {

    public static void main(String[] args) {
        //System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        //System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));

    }

    //用哈希表存储

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return nums.length;
        Set<Integer> numsSet = new HashSet<>();
        for(int num: nums){
            numsSet.add(num);
        }

        int longestlen = 1;
        for(int num: nums){
            if(!numsSet.contains(num - 1)){
                //重新计算连续
                int curlen = 1;
                while(numsSet.contains(num + curlen)){
                    curlen++;
                }
                longestlen = Math.max(longestlen, curlen);
            }
        }
        return longestlen;


    }


        //排序，然后比较
    public static int longestConsecutive1(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return nums.length;
        Arrays.sort(nums);
        int longestlen = 1;
        int curlen = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                continue;
            }else if(nums[i] - nums[i - 1] == 1){
                curlen++;
                longestlen = Math.max(curlen, longestlen);
            } else{
                curlen = 1;
                longestlen = Math.max(curlen, longestlen);
            }
            System.out.println(curlen+"," + longestlen);
        }
        return longestlen;

    }
}
