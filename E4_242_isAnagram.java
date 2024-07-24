package top150;
import java.util.*;

/**
 * 242. 有效字谜

 * 给定两个字符串s和t，如果 t 是 s 的字谜 则返回true ，否则返回 false 。
 *
 * 字谜是通过重新排列不同单词或短语的字母而形成的单词或短语，通常使用所有原始字母恰好一次。
 *
 *
 *
 * 示例 1：
 * 输入： s = “anagram”, t = “nagaram”
 * 输出： true
 *
 * 示例 2：
 * 输入： s = “rat”, t = “car”
 * 输出： false
 */


public class E4_242_isAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));

    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ss = s.charAt(i);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char tt = t.charAt(i);
            if(!map.containsKey(tt) || map.get(tt) == 0) return false;
            map.put(tt, map.getOrDefault(tt, 0) - 1);
        }
        for(char ch : map.keySet()){
            if(map.get(ch) != 0 ) return false;
        }
        return true;

    }
}
