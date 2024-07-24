package top150;

import java.util.Stack;

/**
 * 150. 评估逆波兰表示法
 * 给定一个字符串数组，它表示逆波兰表示法tokens中的算术表达式。
 * 计算表达式的值。返回表示表达式值的整数。
 *
 * 注意：
 * 有效的运算符为'+'、'-'、'*'和'/'。
 * 每个操作数可以是整数或另一个表达式。
 * 两个整数之间的除法总是向零截断。
 * 不会有任何除以零的结果。
 * 输入表示逆波兰表示法中的有效算术表达式。
 * 答案和所有中间计算都可以用32 位整数表示。
 *
 *
 * 示例 1：
 *
 * 输入： tokens = ["2","1","+","3","*"]
 * 输出： 9
 * 解释： ((2 + 1) * 3) = 9
 *
 *
 * 示例 2：
 * 输入： tokens = ["4","13","5","/","+"]
 * 输出： 6
 * 解释： (4 + (13 / 5)) = 6
 *
 *
 * 示例 3：
 * 输入： tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出： 22
 * 解释： ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */

public class G4_150_evalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stacks = new Stack<>();

        for(String s: tokens){
            if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)){
                if(stacks.isEmpty()){return -1;}
                int num1 = stacks.pop();
                int num2 = stacks.pop();
                if("+".equals(s)){
                    stacks.push(num1 + num2);
                }else if("-".equals(s)){
                    stacks.push(num2 - num1);
                }else if("*".equals(s)){
                    stacks.push(num1 * num2);
                }else if("/".equals(s)){
                    stacks.push(num2 / num2);
                }
            }else{
                stacks.push(Integer.valueOf(s));
            }
        }
        return stacks.pop();

    }
}
