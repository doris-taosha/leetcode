package top150;

import java.util.Stack;

/**
 *224. 基本计算器
 * 给定一个表示有效表达式的字符串s，实现一个基本的计算器来对其进行评估，并返回评估结果。
 *
 * 注意：您不能使用任何将字符串评估为数学表达式的内置函数，例如eval()。
 *
 * 示例 1：
 * 输入： s = “1 + 1”
 * 输出： 2
 *
 * 示例 2：
 * 输入： s = " 2-1 + 2 "
 * 输出： 3
 *
 * 示例 3：
 * 输入： s = "(1+(4+5+2)-3)+(6+8)"
 * 输出： 23
 */


public class G5_224_calculate {


    public static void main(String[] args) {
        System.out.println(calculate("1+1"));
        System.out.println(calculate("(2-1+2"));
        System.out.println(calculate("(12-1+2"));
        System.out.println(calculate("(1+(11+101-2)-1)+(6+8)"));

        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        if(s.isEmpty()) return 0;
        int res = 0, sign = 1;
        Stack<Integer> stacks = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = ch - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            }else if(ch == '+' ){
                sign = 1;
            } else if( ch == '-'){
                sign = -1;
            }else if(ch == '('){
                stacks.push(res);
                stacks.push(sign);
                res = 0;
                sign = 1;
            }else if(ch == ')'){
                //第一次弹出的是括号前的付号，第二次弹出的是括号之前的结果
                res = stacks.pop() * res + stacks.pop();
            }
        }
        return res;



    }


    public static int calculate1(String s) {
        if(s.isEmpty()) return 0;

        int res = 0, sign = 1, num = 0;
        Stack<Integer> stacks = new Stack<>();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch)){
                //以防是连续的几位数,当前数字的最后一位
                num = num * 10 + (ch - '0');
            }else if(ch == '+'){
                //数字已经结束
                res += sign * num;
                num = 0;
                sign = 1;
            }else if(ch == '-'){
                res += sign * num;
                num = 0;
                sign = -1;
            }else if(ch == '('){
                stacks.push(res);
                stacks.push(sign);
                sign = 1;
                res = 0;
            }else if(ch == ')'){
                res += sign * num;
                num = 0;
                res *= stacks.pop();
                res += stacks.pop();
            }
        }
        return num != 0 ? res + sign * num : res;

    }
}
