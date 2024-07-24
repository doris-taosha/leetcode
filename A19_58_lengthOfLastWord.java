package top150;


/**
 * 58. 最后一个词的长度
 * s给定一个由单词和空格组成的字符串，返回字符串中最后一个单词的长度。
 * 一个词是最大的
 * 子字符串
 * 仅由非空格字符组成。
 */
public class A19_58_lengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord(" fly me to the moon "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord(" A"));
        System.out.println(lengthOfLastWord("A "));


    }
    public static int lengthOfLastWord(String s) {

        int start = s.length()-1, end = s.length()-1;
        while(start >= 0){
            if(s.charAt(start) == ' '){
                if(start == end){
                    start--;
                    end--;
                }else{
                    return end - start;
                }
            }else{
                start --;
            }

        }
        return end - start;
    }

}
