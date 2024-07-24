package top150;

import java.util.*;

/**
 * 202. 快乐数字
 * 编写一个算法来确定一个数字是否n满意。
 *
 * 快乐数字是通过以下过程定义的数字：
 * 从任意正整数开始，用其数字的平方和替换该数字。
 * 重复该过程直到数字等于 1（它将保持在该位置），或者它会在不包括 1 的循环中无限循环。
 * 对于该过程以 1 结尾的数字来说，这些数字是令人满意的。
 * true 如果 n 是快乐数字 则返回，false 如果不是则返回。
 *
 * 示例 1：
 * 输入： n = 19
 * 输出： true
 * 解释：
 * 1 2 + 9 2 = 82
 * 8 2 + 2 2 = 68
 * 6 2 + 8 2 = 100
 * 1 2 + 0 2 + 0 2 = 1
 *
 *
 * 示例 2：
 * 输入： n = 2
 * 输出： false
 *
 */

public class E7_202_isHappy {


    //问题关键在于如何处理无限循环的情况
    public boolean isHappy(int n) {
        if(n == 1) return true;

        Set<Integer> sets = new HashSet<>(); //判断字符是否重复出现
        while(n != 1){
            int sum = 0;
            while(n != 0){
                int a = n % 10;
                sum+=  a * a;
                n = n / 10;
            }
            if(sets.contains(sum)){
                //开始循环了
                return false;
            }
            n = sum;
            sets.add(sum);
        }
        return true;
    }
}
