package top150;

import java.util.*;


/**
 * 30. 将所有单词连接起来的子字符串
 * 给定一个字符串s和一个字符串数组words。所有字符串的长度words都相同。
 *
 * 连接字符串是恰好包含任何连接排列的所有字符串的字符串words。
 *
 * 例如，如果words = ["ab","cd","ef"]，则"abcdef"，"abefcd"，"cdabef"，"cdefab"，"efabcd"和"efcdab"都是连接字符串。"acdbef"不是连接字符串，因为它不是 的任何排列的连接words。
 * 返回中所有连接子字符串的起始索引数组。您可以按任何顺序s返回答案。
 *
 *
 * 示例 1：
 * 输入： s = “barfoothefoobarman”, words = [“foo”，“bar”]
 * 输出： [0,9]
 * 解释：
 * 从 0 开始的子字符串是"barfoo"。它是 ["bar","foo"]串联的排列words。
 * 从 9 开始的子字符串是"foobar"。它是 ["foo","bar"]串联的排列words。
 *
 * 示例 2：
 * 输入： s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出： []
 * 解释：没有连接的子字符串。
 *
 * 示例 3：
 * 输入： s = “barfoofoobarthefoobarman”，words = [“bar”，“foo”，“the”]
 * 输出： [6,9,12]
 * 解释：
 * 从 6 开始的子字符串是"foobarthe"。它是 的串联["foo","bar","the"]。
 * 从 9 开始的子字符串是"barthefoo"。它是 的串联["bar","the","foo"]。
 * 从 12 开始的子字符串是"thefoobar"。它是 的串联["the","foo","bar"]。
 *
 */
public class C3_30_findSubstring {



    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int arrlen = words.length, wordlen = words[0].length(), slen = s.length();

        if(s.length() < arrlen * wordlen) return res;

        //记录words数组中所有单词出现的频率
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words){
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i < wordlen; i++ ){
            //外层循环 0 ~ wordlen -1 (不然就是重复判断了单词)
            int count = 0;
            Map<String, Integer> tmpMap = new HashMap<>();
            for(int j = i, k = i; j < slen - wordlen + 1; j += wordlen ){
                String temp = s.substring(j, j + wordlen);
                tmpMap.put(temp, tmpMap.getOrDefault(temp, 0) + 1);
                count++;

                if(count == arrlen){
                    //此时滑动窗的大小，刚刚包含所有的单词
                    if(tmpMap.equals(wordMap)) res.add(k);
                    //把最前面的元素移除，继续往后移动, k 就是其实元素的位置
                    String needRemoved = s.substring(k, k + wordlen);
                    if(tmpMap.containsKey(needRemoved) && tmpMap.get(needRemoved) > 1){
                        tmpMap.put(needRemoved, tmpMap.get(needRemoved) - 1);
                    }else{
                        tmpMap.remove(needRemoved);
                    }
                    count--;
                    k = k + wordlen;
                }

            }
        }
        return res;
    }

    public List<Integer> findSubstringqq(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) return res;
        int size = words.length, wordlen = words[0].length(), slen = s.length();
        if(s.length() < size * wordlen) return res;

        //先把words中所有的元素存起来
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i = 0; i < size; i++){
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1 );
        }

        for(int i = 0; i < wordlen; i++){
            //对于从 0 到 wordlen - 1 的每个位置 i，我们以步长 w（每个单词的长度）将窗口滑动到 s 上。
            //因为一旦位置等于wordlen 其实已经在遍历过了
            Map<String, Integer> windowMap = new HashMap<>();
            int count = 0, left = i, right = i;
            for(; right + wordlen <= slen; right = right + wordlen){
                String word = s.substring(right, right + wordlen);

                if(wordMap.containsKey(word)){
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count ++;
                    while(windowMap.get(word) > wordMap.get(word)){
                        //此时已经出现了不需要的单词
                        String needRemoved = s.substring(left, left + wordlen);
                        windowMap.put(needRemoved, windowMap.get(needRemoved) - 1);
                        left += wordlen;
                        count-- ;
                    }
                    if(count == size) res.add(left);

                }else{
                    //该单词不是word需要的
                    windowMap.clear();
                    count = 0;
                    left = right;
                }

            }
        }
        return res;


    }
}
