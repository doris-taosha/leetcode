package top150;


import java.util.*;

/**
 *
 *274. H 指数
 * 给定一个整数数组，citations其中citations[i]表示研究人员的论文被引用的次数，返回该研究人员的 h 指数。ith
 *
 * 根据维基百科对h指数的定义h：h指数是指某研究者发表的h论文至少篇，且每篇论文被引用至少次的最大值h。
 *
 *
 * 示例 1：
 * 输入： citations = [3,0,6,1,5]
 * 输出： 3
 * 解释： [3,0,6,1,5] 表示研究人员总共有 5 篇论文，每篇论文分别获得 3、0、6、1、5 次引用。
 * 由于该研究人员有 3 篇论文每篇引用次数至少为 3 次，其余两篇论文每篇引用次数不超过 3 次，因此他们的 h 指数为 3。
 *
 *
 * 示例 2：
 * 输入： citations = [1,3,1]
 * 输出： 1
 */

public class A11_274_hIndex {


    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex1(citations));
        System.out.println(hIndex1(new int[]{1, 3, 1}));

        System.out.println(hIndex1(new int[]{1}));
        System.out.println(hIndex1(new int[]{100}));

    }

    public static int hIndex1(int[] citations) {
        //排序
        Arrays.sort(citations);
        int maxH = 0;
        int len = citations.length;
        for (int hIndex = len; hIndex > 0; hIndex--) {
            //此时的hIndex就是预设的h指数, 要判断数组中有hIndex的元素大于hIndex
            if(citations[len - hIndex] >= hIndex ){
                return hIndex;
            }

        }
        return maxH;
    }


    public static int hIndex(int[] citations) {
        int maxH = 0;
        for(int i=citations.length; i > 0; i--){
            int count = 0;
            for(int j =0; j< citations.length; j++){
                if(citations[j] >= i) count ++;
                if(count >= i ) {
                    maxH = Math.max(i, maxH);
                }
            }
        }
        return maxH;
    }
}
