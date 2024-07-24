package top150;


import java.util.Arrays;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀字符串。
 *
 * 如果没有公共前缀，则返回空字符串""。
 *
 * 示例 1：
 * 输入： strs = ["flower","flow","flight"]
 * 输出： “fl”
 *
 *
 * 示例 2：
 * 输入： strs = ["dog","racecar","car"]
 * 输出： ""
 * 解释：输入字符串之间没有公共前缀。
 */
public class A20_14_longestCommonPrefix {


    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs); //排序

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            }else{
                break;
            }
        }
        return s1.substring(0, idx);

    }

    //以str[0]为
    public static String longestCommonPrefix1(String[] strs) {

        if(strs.length == 0) return "";
        int i=0;
        String sample = strs[0];
        StringBuilder sb = new StringBuilder();
        while(i < sample.length()){
            for(int ss = 1; ss < strs.length ; ss++){
                System.out.println(strs[ss]);
                if(strs[ss].length() <= i) return sb.toString();
                if(sample.charAt(i) != strs[ss].charAt(i)) return sb.toString();
            }
            sb.append(sample.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
