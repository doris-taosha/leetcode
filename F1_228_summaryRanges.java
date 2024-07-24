package top150;
import java.util.*;


/**
 *
 *228. 摘要范围

 * 给定一个已排序的唯一整数数组nums。
 *
 * 范围是从a到b（包括）的 [a,b]所有整数的集合
 * 返回最小的有序列表，该列表精确地覆盖数组中的所有数字。也就是说，的每个元素nums都恰好被其中一个范围覆盖，并且不存在整数x位于x其中一个范围中但不位于 中nums。
 *
 * [a,b]列表中的每个范围应输出为：
 *
 * "a->b"如果a != b
 * "a"如果a == b
 *
 * 示例 1：
 *
 * 输入： nums = [0,1,2,4,5,7]
 * 输出： ["0->2","4->5","7"]
 * 解释：范围是：
 * [0,2]-->“0->2”
 * [4,5]-->“4->5”
 * [7,7] --> “7”
 * 示例 2：
 *
 * 输入： nums = [0,2,3,4,6,8,9]
 * 输出： ["0","2->4","6","8->9"]
 * 解释：范围是：
 * [0,0] --> “0”
 * [2,4]-->“2->4”
 * [6,6] --> “6”
 * [8,9]-->“8->9”
 *
 */

public class F1_228_summaryRanges {

    public static void main(String[] args) {
        //List<String> res = summaryRanges(new int[]{0,1,2,4,5,7});
        List<String> res = summaryRanges(new int[]{0,2,3,4,6,8,9});

        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;

        int left = 0, right = 0;
        for(; right < nums.length; right++){
            if(right > 0 && nums[right] - nums[right - 1] != 1){
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(nums[left]));
                if(right - left > 1) {
                    sb.append("->").append(String.valueOf(nums[right-1]));
                }
                res.add(sb.toString());
                left = right;
            }
        }
        if(left == nums.length - 1){
            res.add(String.valueOf(nums[left]));
        }else{
            res.add(nums[left] + "->" + nums[right - 1]);
        }
        return res;
    }
}
