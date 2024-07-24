package top150;

import java.util.*;



/**
 *49. 组字谜

 * 给定一个字符串数组strs，将字母重排组合在一起。您可以按任意顺序返回答案。
 * 字谜是通过重新排列不同单词或短语的字母而形成的单词或短语，通常使用所有原始字母恰好一次。
 *
 *
 *
 * 示例 1：
 * 输入： strs = ["eat","tea","tan","ate","nat","bat"]
 * 输出： [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2：
 * 输入： strs = [""]
 * 输出： [[""]]
 *
 * 示例 3：
 * 输入： strs = ["a"]
 * 输出： [["a"]]
 *
 */

public class E5_49_groupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);  //排序后的字符串作为map的key

            if(!strMap.containsKey(sortedStr)){
                strMap.put(sortedStr, new ArrayList<>());
            }
            strMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(strMap.values());

    }
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> strMap = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            //用排序后的字符用作key
            String sortedStr = sortStr(strs[i]);
            if(strMap.containsKey(sortedStr)){
                List<String> tmp = strMap.get(sortedStr);
                tmp.add(strs[i]);
            }else{
                List<String> arrList = new ArrayList<>();
                arrList.add(strs[i]);
                strMap.put(sortedStr, arrList);
            }
        }
        for(String sortedStr : strMap.keySet()){
            res.add(strMap.get(sortedStr));
        }
        return res;

    }

    public String sortStr(String s){
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }


}
