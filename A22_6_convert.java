package top150;

/**
 * 6. Zigzag Conversion
 * he string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 **
 *
 * =====================================================
 =====Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"

 =====Example 2:
 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:
 P     I    N
 A   L S  I G
 Y A   H R
 P     I

 =====Example 3:
 Input: s = "A", numRows = 1
 Output: "A"

 */

public class A22_6_convert {


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));

    }
    public static String convert(String s, int numRows) {
        int len = s.length();
        if(numRows == 1 || numRows >= len) return s;

        StringBuilder sb = new StringBuilder();
        char[] sArr = s.toCharArray();

        int step = 2* numRows - 2;
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length(); j += step){
                sb.append(sArr[j]); //第一行和最后一行的间隔只是step
                //针对中间的行，有额外的值需要填充
                if( i >= 1 && i <= numRows - 2 && j + (step - 2 * i) < len){
                    //第i行， 要在之间间隔上再减少2 * i
                    sb.append(sArr[j + (step - 2 * i)]);
                }
            }
        }
        return sb.toString();

    }


}
