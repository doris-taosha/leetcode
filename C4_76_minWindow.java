package top150;

import java.util.*;

/**
 * 76. 最小窗口子串
 * 给定两个长度分别为s和t的 字符串，返回最小窗口子字符串
 * 使得s中的每个字符t（包括重复字符）都包含在窗口t中。如果不存在这样的子字符串，则返回空字符串""。
 *
 * 生成的测试用例的答案将是唯一的。
 *
 * 示例 1：
 *
 * 输入： s = “ADOBECODEBANC”, t = “ABC”
 * 输出： “BANC”
 * 解释：最小窗口子串“BANC”包括字符串 t 中的“A”、“B”和“C”。
 * 示例 2：
 *
 * 输入： s = "a", t = "a"
 * 输出： “a”
 * 解释：整个字符串 s 是最小窗口。
 * 示例 3：
 *
 * 输入： s = "a", t = "aa"
 * 输出： ""
 * 解释： t 中的两个“a”都必须包含在窗口中。
 * 由于 s 的最大窗口只有一个“a”，因此返回空字符串。
 *
 */
public class C4_76_minWindow {

    public String minWindow(String s, String t) {
        if(s.length() < t.length() ) return "";

        //先把t字符串中的字符存起来
        Map<Character, Integer> tMap = new HashMap<>();
        for(char tt : t.toCharArray()){
            tMap.put(tt, tMap.getOrDefault(tt, 0) + 1);
        }

        int rl = 0, rr = 0;
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, have = 0, needCount = tMap.size();
        Map<Character,Integer> windowMap = new HashMap();
        while(right < s.length()){
            char ss = s.charAt(right);
            windowMap.put(ss, windowMap.getOrDefault(ss, 0) + 1);

            if(windowMap.get(ss).equals(tMap.getOrDefault(ss, 0)))  have ++;
            while(left <= right && have == needCount){
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    rl = left; rr = right;
                }
                char leftCh = s.charAt(left);
                windowMap.put(leftCh, windowMap.getOrDefault(leftCh,0) - 1);
                if(tMap.getOrDefault(leftCh, 0)  > windowMap.get(leftCh)){
                    have--;
                }
                left++;
            }
            right++;
        }
        return minLen != Integer.MAX_VALUE ? s.substring(rl, rr+1 ) : "";


    }
}
