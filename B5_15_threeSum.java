package top150;

import java.util.*;



/**
 * 15. 3Sum
 * 给定一个整数数组 nums，返回所有三元组[nums[i], nums[j], nums[k]]，使得i != j，i != k， 和j != k，nums[i] + nums[j] + nums[k] == 0。
 *
 * 请注意，解决方案集不能包含重复的三元组。
 */
public class B5_15_threeSum {


    public static void main(String[] args) {

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums); //排序
        int len = nums.length;
        for(int i = 0; i < len - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = len - 1;
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    res.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    left++; right--;
                    //此时去重判断
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }

                }else if(nums[left] + nums[right] + nums[i] < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }



    //暴力法
    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(nums[i]+nums[k]+nums[j] == 0 ){
                        List<Integer> in = new ArrayList<>();
                        in.add(nums[i]);in.add(nums[j]);in.add(nums[k]);

                        //map 难以判断去重的条件
                        res.add(in);
                        System.out.println(res);

                    }
                }

            }
        }
        return new ArrayList<>(res);
    }

}
