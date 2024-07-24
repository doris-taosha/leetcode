package top150;


/**
 * 80. 从排序数组中删除重复项 II

 * nums给定一个按非降序排序的整数数组，就地删除一些重复项，使得每个唯一元素最多出现两次。元素的相对顺序应保持不变。
 */
public class A4_80_removeDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] nums1 = new int[]{0,0,1,1,1,1,2,3,3};

        System.out.println(removeDuplicates(nums1));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1 || nums.length == 2) return nums.length;

        int slowP = 1;
        for(int fastP = 2; fastP < nums.length; fastP++){
            if(nums[fastP] == nums[slowP] && nums[slowP ] == nums[slowP-1]){

            }else{
                slowP++;
                nums[slowP] = nums[fastP];
            }
        }
        return slowP + 1;
    }
}
