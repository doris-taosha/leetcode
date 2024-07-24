package top150;


import java.util.Stack;

/**
 *125. 有效回文

 * 如果将短语中的所有大写字母转换为小写字母并删除所有非字母数字字符后，正读和反读都一样，则该短语为回文。字母数字字符包括字母和数字。

 * 给定一个字符串s，如果它是回文，则返回true，否则返回false。
 *示例 1：
 *
 * 输入： s = "A man, a plan, a canal: Panama"
 * 输出： true
 * 解释： “amanaplanacanalpanama”是回文。
 * 示例 2：
 *
 * 输入： s = "race a car"
 * 输出： false
 * 解释： “raceacar”不是回文。
 * 示例 3：
 *
 * 输入： s = " "
 * 输出： true
 * 解释： s 删除非字母数字字符后为空字符串“”。
 * 由于空字符串正读和倒读是一样的，所以它是回文。
 *
 *
 */
public class B1_125_isPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));

        System.out.println(isPalindrome("  "));
        System.out.println(isPalindrome("0P"));

    }

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int leftP = 0, rightP = s.length() - 1;

        while(leftP <= rightP){
            char lfStr = s.charAt(leftP);
            char rgStr = s.charAt(rightP);

            if(!Character.isLetterOrDigit(lfStr)){
                leftP++;
            }else if(!Character.isLetterOrDigit(rgStr)){
                rightP--;
            }else{
                if(Character.toLowerCase(lfStr) != Character.toLowerCase(rgStr)){
                    return false;
                }
                leftP++;
                rightP--;
            }

        }
        return true;

    }
}
