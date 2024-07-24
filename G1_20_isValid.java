package top150;

import java.util.Stack;

/**
 * 20. 有效括号
 * 给定一个s仅包含字符'('、')'、'{'、'}'和'['的字符串']'，确定输入字符串是否有效。
 *
 * 如果满足以下条件，则输入字符串有效：
 * 左括号必须由相同类型的括号闭合。
 * 左括号必须按照正确的顺序闭合。
 * 每个闭括号都有一个相同类型的对应开括号。
 *
 *
 * 示例 1：
 * 输入： s = "()"
 * 输出： true
 *
 * 示例 2：
 * 输入： s = "()[]{}"
 * 输出： true
 *
 * 示例 3：
 * 输入： s = "(]"
 * 输出： false
 */
public class G1_20_isValid {

    public static void main(String[] args) {

        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));

    }
    public static boolean isValid(String s) {
        if(s == null || s.isEmpty()) return true;
        if(s.length() % 2 != 0) return false;
        Stack<Character> stacks = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '{'){
                stacks.push('}');
            }else if(ch == '('){
                stacks.push(')');
            }else if(ch == '['){
                stacks.push(']');
            }else{
                if(stacks.isEmpty() || stacks.pop() != ch){
                    return false;
                }
            }
        }
        return stacks.isEmpty();
    }

}
