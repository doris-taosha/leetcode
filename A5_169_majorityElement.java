package top150;


import java.util.*;


/**
 * 169. 多数元素
 * nums给定一个大小的数组n，返回多数元素。
 *
 * 众数元素是出现次数超过 100 次的元素⌊n / 2⌋。你可以假设众数元素始终存在于数组中。
 *
 * 思路：
 */
public class A5_169_majorityElement {



    //投票法
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        if(nums.length == 1) return candidate;

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if( nums[i] == candidate){
                count ++;
            }else{
                count --;
            }
            if(count == 0 && i < nums.length - 1) {
                candidate = nums[i+1];
            }
        }
        return candidate;
    }
        //利用map存储出现的次数
    public int majorityElement1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            if(count > nums.length / 2) return nums[i];
        }
        return -1;
    }

}
