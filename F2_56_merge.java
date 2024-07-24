package top150;
import java.util.*;


/**
 * 56. 合并间隔
 * intervals 给定一个数组，合并所有重叠区间，并返回一个覆盖输入中所有区间的非重叠区间数组。intervals[i] = [starti, endi]
 *
 * 示例 1：
 * 输入： intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出： [[1,6],[8,10],[15,18]]
 * 解释：由于区间 [1,3] 和 [2,6] 重叠，因此将它们合并为 [1,6]。
 *
 *
 * 示例 2：
 * 输入： intervals = [[1,4],[4,5]]
 * 输出： [[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 被视为重叠。
 *
 */
public class F2_56_merge {


    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        if(size == 1) return intervals;

        List<int[]> ans = new LinkedList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); //按照数组第一个元素排序
        int start = intervals[0][0], end = intervals[0][1]; //第一个元素的左右区间

        for(int i = 1; i < size; i++){
            if(intervals[i][0] < end){
                //左侧可以合并
                if(intervals[i][1] > end){
                    //取并集
                    end = intervals[i][1];
                }
            }else{
                //左侧不可合并，要单独拧出来
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        //如果最后一个
        ans.add(new int[]{start, end});
        int [][] res = new int[ans.size()][2];

        for(int i = 0; i < ans.size(); i++){
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }
        return res;


    }

    public int[][] merge1(int[][] intervals) {
        int size = intervals.length;
        if(size == 1) return intervals;

        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0], end = intervals[0][1]; //第一个元素的左右区间
        for(int i = 1; i < size; i++){
            if(intervals[i][0] <= end){
                //可以合并
                if(intervals[i][1] > end) end = intervals[i][1];
            }else{
                //不能合并
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        System.out.println(res.size());

        int[][] ans = new int[res.size()][2];
        int j = 0;
        for (int[] arr : res) {
            ans[j][0] = arr[0];
            ans[j][1] = arr[1];
            j++;
        }

        return ans;

    }
}
