package top150;

/**
 *27.删除元素
 * 给定一个整数数组nums和一个整数，就地删除中val所有出现的。元素的顺序可能会改变。然后返回中不等于 的元素数量。valnums numsval
 *
 * 考虑中元素的数量nums不等于val，k为了被接受，您需要执行以下操作：
 *
 * 改变数组nums，使得k的第一个元素nums包含不等于 的元素val。 的其余元素nums以及 的大小并不重要nums。
 * 返回k。
 */


public class A2_27_removeElement {


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums, 2));
        System.out.println(nums[0]);
    }



    //同向快慢指针
    public static int removeElement(int[] nums, int val) {
        int slowPoint = 0;
        for(int fastPoint = 0; fastPoint < nums.length; fastPoint++){
            if(nums[fastPoint]!= val){
                nums[slowPoint] = nums[fastPoint];
                slowPoint++;
            }
        }
        return slowPoint;


    }

    //相向左右指针 --- 会改变元素相对位置
    public static int removeElement1(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else{
                left++;
            }
        }
        return left;
    }
}
