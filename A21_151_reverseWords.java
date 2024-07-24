package top150;

/**
 * 151. 反转字符串中的单词
 *
 * 给定一个输入字符串，反转单词s的顺序。
 * 单词定义为非空格字符序列。中的单词将s至少由一个空格分隔。
 *
 * 返回由单个空格连接的按相反顺序排列的单词的字符串。
 *
 * 请注意，s两个单词之间可能包含前导或尾随空格或多个空格。返回的字符串应该只有一个空格来分隔单词。不要包含任何额外的空格。
 */


public class A21_151_reverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println("aaa");
    }

    //不借助外部函数
    //清多余的空格、反正整个字符串，返回单个单词
    public static String reverseWords(String s) {
        if(s == null) return null;
        String newStr = cleanSpace(s);
        System.out.println(newStr);

        char[] newStrs = newStr.toCharArray();
        //反转整个字符串
        reverseStr(newStrs, 0, newStr.length() - 1);
        //反转每个单词
        reverseEachWord(newStrs);
        return new String(newStrs);

    }

    public static void reverseEachWord(char[] strs) {
        int start = 0, end = 0;
        while(end < strs.length){
            if(strs[end] == ' ' ){
                reverseStr(strs, start, end - 1);
                start = end + 1;
            }
            end++;
            if(end == strs.length){
                reverseStr(strs, start, end - 1);
            }
        }
        //处理最后一个单词
        //reverseStr(strs, start, end - 1);
    }
    public static void reverseEachWord_old(char[] strs) {
        int start = 0, end = 0;
        while(end < strs.length){
            if(strs[end] != ' '){
                end++;
            }else{
                reverseStr(strs, start, end - 1);
                end++;
                start = end;
            }
        }
        //处理最后一个单词
        reverseStr(strs, start, end - 1);
    }

    public static void reverseStr(char[] strs, int start, int end) {
        while(start < end){
            char tmp = strs[start];
            strs[start] = strs[end];
            strs[end] = tmp;
            start++;
            end--;
        }

    }

        //去掉首、尾、中间多余的空格
    public static String cleanSpace(String s){
        int slowP = 0, fastP = 0;
        char[] strs  = s.toCharArray();
        int len = s.length();
        while(fastP < len){
            //去除首部多余的空格
            while(fastP < len && strs[fastP] == ' '){
                fastP++;
            }
            //遇到单词
            while(fastP < len && strs[fastP] != ' '){
                strs[slowP] = strs[fastP];
                slowP++;
                fastP++;
            }
            //中间单词遇到空格后
            while(fastP < len && strs[fastP] == ' '){
                fastP++;
            }
            //不是最后一个单词
            if(fastP < len) {
                strs[slowP] = ' ';
                slowP++;
            }
        }
        return new String(strs).substring(0, slowP);

    }




    //借助trim split函数
    public static String reverseWords1(String s) {
        if(s == null ) return null;
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i > 0; i--){
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}
