package top150;


/**
 * 238. 数组除自身以外的乘积
 * 给定一个整数数组nums，返回一个数组 answer ，使得 answer[i] 等于 nums 除之外 nums[i]的所有元素的乘积。
 *
 * 任何前缀或后缀的乘积nums都保证适合32 位整数。
 *
 * 您必须编写一个能够及时运行 O(n) 且无需使用除法运算的算法。
 */
public class A13_238_productExceptSelf {


    //某个元素除自身外的其他元素的乘积
    public int[] productExceptSelf(int[] nums) {
        //计算某个元素左侧的元素乘积
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i< nums.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >=0; i--){
            right[i] = right[i+1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
