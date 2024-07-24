package top150;

/**
 * 88. 合并排序数组
 * 给定两个按非降序nums1排序的整数数组和，以及两个整数和，分别表示和中的元素数量。nums2mnnums1nums2
 */
public class A1_88_merge {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        merge(nums1, 3, new int[]{2,5,6}, 3);
        for(int i=0; i< nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int len = m + n - 1;
        while(m > 0 && n > 0){
            if(nums1[m-1] >= nums2[n-1]){
                nums1[len] = nums1[m-1];
                m--;
            }else {
                nums1[len] = nums2[n-1];
                n--;
            }
            len--;
        }
        while(n > 0){
            nums1[n-1] = nums2[n-1];
            n--;
        }
    }
}
