package top150;

/**
 * 28. 查找字符串中第一次出现的索引

 * 给定两个字符串needle和haystack ，返回needle在haystack中第一次出现的索引，或者如果不是其一部分就返回-1。
 *
 * 示例 1：
 *
 * 输入： haystack = "sadbutsad",needle = "sad"
 * 输出： 0
 * 解释： “sad”出现在索引 0 和 6 处。
 * 第一次出现是在索引 0 处，因此我们返回 0。
 * 示例 2：
 *
 * 输入： haystack = "leetcode",needle = "leeto"
 * 输出： -1
 * 解释： “leeto”没有出现在“leetcode”中，所以我们返回-1。
 */

public class A23_28_strStr {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("a", "a"));

    }

    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while(j < needle.length()){
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    break;
                }
                j++;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }

    //直接采用截取的方式判断字符串是否相等
    public static int strStr1(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            if(needle.equals(haystack.substring(i, needle.length() + i))){
                return i;
            }
        }
        return -1;

    }

}
