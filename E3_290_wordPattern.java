package top150;

import java.util.*;

/**
 * 290. 单词模式
 * 给定pattern和一个字符串s，查找s是否遵循相同的模式。
 * 这里的follow表示完全匹配。
 *
 * 示例 1：
 * 输入： pattern = “abba”，s = “dog cat cat dog”
 * 输出： true
 *
 * 示例 2：
 * 输入： pattern = “abba”，s = “dog cat cat fish”
 * 输出： false
 *
 * 示例 3：
 * 输入： pattern = "aaaa", s = "dog cat cat dog"
 * 输出： false
 */
public class E3_290_wordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));

    }

    public static boolean wordPattern(String pattern, String s) {
        String[] arrs = s.split(" ");
        if(pattern.length() != arrs.length) return false;

        Map<Character, String> p2sMap = new HashMap<>();
        Map<String, Character> s2pMap = new HashMap<>();

        for(int i = 0; i < arrs.length; i++){
            char ch = pattern.charAt(i);
            if(p2sMap.containsKey(ch) &&  !p2sMap.get(ch).equals(arrs[i])){
                return false;
            }
            if(s2pMap.containsKey(arrs[i]) &&  !s2pMap.get(arrs[i]).equals(ch)){
                return false;
            }
            p2sMap.put(ch, arrs[i]);
            s2pMap.put(arrs[i], ch);
        }
        return true;

    }

}
