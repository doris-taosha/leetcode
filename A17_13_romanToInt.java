package top150;

import java.io.ObjectOutputStream;
import java.util.*;

/**
 * 13. 罗马数字转整数
 * 罗马数字由七种不同的符号表示 ：I、、、、、和。VXLCDM
 *
 * 符号       值
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * 例如， 用罗马数字2写成II ，就是两个一相加。12写成 XII，就是X + II。 数字27写成XXVII，就是XX + V + II。
 *
 * 罗马数字通常从左到右按从大到小的顺序书写。但是，表示四的数字不是IIII。相反，四写成IV。因为一在五之前，所以我们减去一，得到四。同样的原则也适用于数字九，它写成IX。有六种情况使用减法：
 *
 * I可放在V（5）和X（10）之前，得到4和9。
 * X可以放在L(50) 和C(100) 之前，这样就得到了 40 和 90。
 * C可以放在D(500) 和M(1000) 之前，这样就得到了 400 和 900。
 * 给定一个罗马数字，将其转换为整数。
 */

public class A17_13_romanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum += -map.get(s.charAt(i));
            }else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;


    }
}
