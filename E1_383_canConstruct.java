package top150;
import java.util.*;


/**
 *
 * 383. 赎金票据 Ransom Note
 *
 * 给定两个字符串ransomNote和，如果可以使用magazine 中的字母构造ransomNote，则返回true，否则返回false.
 * magazine中的每个字母ransomNote只能使用一次。
 *
 *
 *
 * 示例 1：
 * 输入： ransomNote = “a”, magazine = “b”
 * 输出： false
 *
 * 示例 2：
 * 输入： ransomNote = "aa", magazine = "ab"
 * 输出： false
 *
 * 示例 3：
 * 输入： ransomNote = "aa", magazine = "aab"
 * 输出： true
 */



public class E1_383_canConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() >  magazine.length()) return false;

        Map<Character, Integer> mgMap = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            mgMap.put(ch, mgMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if(mgMap.containsKey(ch) && mgMap.get(ch) > 0){
                mgMap.put(ch, mgMap.get(ch) - 1);
            }else{
                return false;
            }
        }
        return true;
    }

}
