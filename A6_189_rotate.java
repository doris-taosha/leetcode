package top150;


/**
 *189. 旋转数组
 * 给定一个整数数组nums，将数组向右旋转，k步骤为，其中k为非负。
 *
 * 示例 1：
 *
 * 输入： nums = [1,2,3,4,5,6,7], k = 3
 * 输出： [5,6,7,1,2,3,4]
 * 解释：
 * 向右旋转 1 步：[7,1,2,3,4,5,6]
 * 向右旋转 2 步：[6,7,1,2,3,4,5]
 * 向右旋转 3 步：[5,6,7,1,2,3,4]
 * 示例 2：
 *
 * 输入： nums = [-1,-100,3,99], k = 2
 * 输出： [3,99,-1,-100]
 * 解释：
 * 向右旋转1步：[99，-1，-100,3]
 * 向右旋转2步：[3,99，-1，-100]
 */


public class A6_189_rotate {


    public static void main(String[] args) {
        //int [] nums = new int[]{1,2,3,4,5,6,7};
        int [] nums1 = new int[]{-1, -100, 3, 99};

        rotate(nums1, 2);
        for(int i = 0; i < nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }


    public static  void rotate1(int[] nums, int k) {
        k = k % nums.length; //求余，（当旋转次数等于nums.length时 等于没有旋转）

    }


    //旋转三次
    public static  void rotate(int[] nums, int k) {
        k = k % nums.length; //求余，（当旋转次数等于nums.length时 等于没有旋转）
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }
    public static void swap(int[] nums, int left, int right){
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

}
