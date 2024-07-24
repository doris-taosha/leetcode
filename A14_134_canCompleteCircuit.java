package top150;


/**
 * 134. 加油站
 * 环形路线上有n座加油站，每站汽油容量为。ithgas[i]
 *
 * 你有一辆油箱无限量的汽车，cost[i]从一站到下一站需要花费 汽油。你在一个加油站开始旅程，油箱已经空了。ith(i + 1)th
 *
 * 给定两个整数数组gas和，如果你可以顺时针方向绕圈一圈，则cost返回起始加油站的索引，否则返回。如果存在解决方案，则保证它是唯一的 -1
 */
public class A14_134_canCompleteCircuit {




    public int canCompleteCircuit(int[] gas, int[] cost) {
        //找到能满足要求的正确的起点
        int n = gas.length;

        int totalGas = 0, totalCost = 0;

        //先判断总的汽油 和总的消耗大小
        for(int i = 0; i < n; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost)  return -1;


        //满足要求， 就开始寻找合适的起点
        int start = 0, remainGas = 0;
        for(int i = 0; i < n; i++){
            remainGas =  remainGas + (gas[i] - cost[i]);
            if(remainGas < 0){
                start = i + 1;  //重新选择起点
                remainGas = 0;
            }
        }
        return start;


    }
}
