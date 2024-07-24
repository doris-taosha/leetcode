package top150;


/**
 * 392. 是子序列

 * 给定两个字符串s和t，如果s是t的子序列 则返回true，否则返回false。
 *
 * 字符串的子序列是在不打乱原字符串相对位置的情况下，通过删除部分（也可以不删除）字符而形成的新字符串。（即 是的子"ace"序列而 不是 的）。"abcde""aec"

 示例 1：
 输入： s = “abc”, t = “ahbgdc”
 输出： true


 示例 2：
 输入： s = “axc”, t = “ahbgdc”
 输出： false

 */

public class B2_392_isSubsequence {


    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));

    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;

        int sp = 0, tp = 0;
        while(sp < s.length() && tp < t.length()){
            if(s.charAt(sp) == t.charAt(tp)){
                sp++;
            }
            tp++;
        }
//        if(sp == s.length()){
//            return true;
//        }else{
//            return false;
//        }

        return sp == s.length();
    }

}
