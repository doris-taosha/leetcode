package top150;

import java.util.*;

/**
 * 205. 同构字符串
 * 给定两个字符串s和t，确定它们是否同构。
 *
 * 若s中的字符可以替换得到t，则两个字符串s和t是同构的
 *
 * 所有出现的字符都必须用另一个字符替换，同时保持字符顺序不变。任何两个字符都不能映射到同一个字符，但一个字符可以映射到自身。
 *
 * 示例 1：
 * 输入： s = "egg", t = "add"
 * 输出： true
 *
 * 示例 2：
 * 输入： s = “foo”, t = “bar”
 * 输出： false
 *
 * 示例 3：
 * 输入： s = “paper”, t = “title”
 * 输出： true
 */


public class E2_205_isIsomorphic {


    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));


    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> s2tMap = new HashMap<>();
        Map<Character, Character> t2sMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if((s2tMap.containsKey(sch) && s2tMap.get(sch) != tch) || (t2sMap.containsKey(tch) && t2sMap.get(tch) != sch)){
                return false;
            }
            //要判断是否两个字符存在相同的映射
            s2tMap.put(sch, tch);
            t2sMap.put(tch, sch);

        }
        return true;
    }
}
