package top150;


/**
 * 55. 跳跃游戏
 * 给你一个整数数组nums。你的初始位置是数组的第一个索引，数组中的每个元素代表你在该位置的最大跳跃长度。
 *
 * true若可以到达最后一个索引则返回，false否则。
 */
public class A9_55_canJump {

    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        int reachIndex = 0; //能达到的最远索引，会一直更新
        for(int i = 0; i < nums.length; i++){
            if(i > reachIndex) {
                //此时已经无法达到当前遍历的值
                return false;
            }
            //比较某个点能达到的最远距离 和 上一节点能达到的最远距离
            reachIndex = Math.max(i + nums[i], reachIndex);

            if(reachIndex >= nums.length - 1){
                //此时已经能达到最后了，可以提前退出
                return true;
            }
        }
        return true;
    }
}
