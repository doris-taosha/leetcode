package top150;

import java.util.*;

/***
 *3. 最长无重复字符的子字符串

 * 给定一个字符串s，找到没有重复的最长子字符串
 *
 * 示例 1：
 * 输入： s = "abcabcbb"
 * 输出： 3
 * 解释：答案是“abc”，长度为 3。
 *
 *
 * 示例 2：
 * 输入： s = "bbbbb"
 * 输出： 1
 * 解释：答案是“b”，长度为 1。
 *
 * 示例 3：
 * 输入： s = "pwwkew"
 * 输出： 3
 * 解释：答案为“wke”，长度为 3。
 * 注意答案必须是子字符串，“pwke”是子序列而不是子字符串。
 *
 */
public class C2_3_lengthOfLongestSubstring {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1 ) return s.length();
        Set<Character> sets = new HashSet<>();
        //Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxlen = 0;
        for(; right < s.length(); right++){
            char ss = s.charAt(right);
            while(sets.contains(ss)){
                sets.remove(s.charAt(left));
                left++;
            }
            sets.add(ss);
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;

    }


}
