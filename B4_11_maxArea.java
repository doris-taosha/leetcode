package top150;

/**
 * 11. 盛满水的容器
 * 给定一个height长度为 的整数数组n。n绘制两条垂直线，使得线的两个端点分别为和。ith(i, 0)(i, height[i])
 *
 * 找到两条线，与 x 轴一起组成一个容器，使得容器中装有最多的水。
 *
 * 返回容器可容纳的最大水量。
 *
 * 请注意不要倾斜容器。
 */
public class B4_11_maxArea {


    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6}));

    }
    public static int maxArea(int[] height) {
        int n = height.length, left = 0, right = n - 1;
        int maxArea = 0;
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

}
