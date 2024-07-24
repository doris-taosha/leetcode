package top150;

import java.util.*;

/**
 * 57. 插入间隔

 * 给定一个不重叠间隔的数组intervals，其中表示间隔的开始和结束，并按 升序排序。还给定一个表示另一个间隔的开始和结束的间隔。intervals[i] = [starti, endi]ithintervalsstartinewInterval = [start, end]
 *
 * 插入newInterval到intervals仍然intervals按升序排序并且仍然没有任何重叠区间（如果需要，合并重叠区间）。startiintervals
 *
 * intervals插入后返回。
 *
 * 请注意，您不需要intervals就地修改。您可以创建一个新数组并返回它。
 *
 *
 * 示例 1：
 * 输入： intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出： [[1,5],[6,9]]
 *
 *
 * 示例 2：
 * 输入： intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出： [[1,2],[3,10],[12,16]]
 * 解释：因为新区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */

public class F3_57_insert {


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        if(newInterval.length == 0) return intervals;

        boolean inserted = false;
        for(int i = 0; i < intervals.length; i++){
            int left = intervals[i][0], right = intervals[i][1];
            if(right < newInterval[0]){ //没有重叠,,待插入元素在当前元素之后之前，直接添加当前元素
                ans.add(intervals[i]);
            }else if(newInterval[1] < left){
                //没有重叠, 被插入元素在当前元素之前,,要保证只加入一次
                if(!inserted){
                    ans.add(newInterval);
                    inserted = true;
                }
                ans.add(intervals[i]);
            }else{
                newInterval[0] = Math.min(left, newInterval[0]);
                newInterval[1] = Math.max(right, newInterval[1]);
            }
        }
        if(!inserted){
            //目标元素最后都没有被插入
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
