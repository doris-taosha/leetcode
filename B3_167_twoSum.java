package top150;

import java.util.*;


/**
 *167. 两数之和 II - 输入已排序数组
 * 给定一个已按非降序排序的1 索引整数数组，找到两个数字，使得它们加起来等于特定数字
 *
 * 示例 1：
 * 输入： numbers = [ 2 , 7 ,11,15], target = 9
 * 输出： [1,2]
 * 解释： 2 加 7 等于 9。因此，索引1 = 1，索引2 = 2。我们返回 [1, 2]。
 *
 * 示例 2：
 * 输入： numbers = [ 2 ,3, 4 ], target = 6
 * 输出： [1,3]
 * 解释： 2 加 4 等于 6。因此索引1 = 1，索引2 = 3。我们返回 [1, 3]。
 *
 * 示例 3：
 * 输入： numbers = [ -1 , 0 ], target = -1
 * 输出： [1,2]
 * 解释： -1 和 0 之和为 -1。因此索引1 = 1，索引2 = 2。我们返回 [1, 2]。
 */


public class B3_167_twoSum {



    //利用双指针
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left, right};
            }else if(numbers[left] + numbers[right] < target){
                left ++;
            }else{
                right --;
            }
        }
        return new int[]{-1,-1};


    }

    //利用额外map存储元素及索引
    public int[] twoSum1(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< numbers.length; i++){
            int needValue = target - numbers[i];
            if(map.containsKey(needValue)){
                return new int[]{ map.get(needValue),i + 1};
            }else{
                map.put(numbers[i], i+1);
            }
        }
        return new int[]{-1,-1};



    }




}
