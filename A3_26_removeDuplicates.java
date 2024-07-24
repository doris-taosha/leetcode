package top150;

/**
 * 26. 从排序数组中删除重复项

 * nums给定一个按非降序排序的整数数组，就地删除重复项，使得每个唯一元素只出现一次。元素的相对顺序应保持不变。然后返回中唯一元素的数量nums。
    ---相对位置保持不变---
 */
public class A3_26_removeDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }


    public static int removeDuplicates(int[] nums) {
        if(nums != null && nums.length == 1) return 1;

        int slowP = 0;
        for(int fastP = 1; fastP < nums.length; fastP++){
            if( nums[fastP] != nums[slowP]){
                slowP++;
                nums[slowP] = nums[fastP];
            }
        }
        return slowP+1;
    }


    //
    public static int removeDuplicates1(int[] nums) {
        if(nums != null && nums.length == 1) return 1;

        int slowP = 0;
        for(int fastP = 0; fastP < nums.length; fastP++){
            if( fastP > 0 && nums[fastP] != nums[slowP]){
                slowP++;
                nums[slowP] = nums[fastP];
            }
        }
        return slowP+1;
    }
}
