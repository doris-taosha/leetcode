package top150;

import java.util.Map;

/**
 * 45. 跳跃游戏 II

 * 您将获得一个长度为n的整数数组。您的初始位置为nums[0]
 *
 * 每个元素nums[i]代表从索引 向前跳转的最大长度i。换句话说，如果你在nums[i]，你可以跳转到任何nums[i + j]地方：
 *
 * 0 <= j <= nums[i]和
 * i + j < n
 * 返回达到 所需的最少跳跃次数nums[n - 1]。测试用例的生成是为了让您能够达到nums[n - 1]。
 */


public class A10_45_jump {

    public static void main(String[] args) {
        //int[] nums = new int[]{2,3,0,1,4};
        int[] nums = new int[]{0};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int fastIndex = 0;
        int count = 0;
        int curReachedIndex = 0;

        for(int i=0; i < nums.length - 1; i++){
            fastIndex = Math.max(nums[i] + i, fastIndex);
            if(fastIndex >= nums.length - 1){
                count++;
                return count;
            }
            if(i == curReachedIndex){
                //之前节点一步能跳到的最远位置内
                count++;
                curReachedIndex = fastIndex;
            }
        }
        return count;
    }
}
