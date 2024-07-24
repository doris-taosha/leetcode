package top150;

/**
 * 12. 整数转罗马数
 * 七种不同的符号代表具有以下值的罗马数字：
 *
 *罗马数字由小数位数值从最高位到最低位的转换结果组成。将小数位数值转换为罗马数字有以下规则：
 *
 * 如果值不是以 4 或 9 开头，则选择可以从输入中减去的最大值的符号，将该符号附加到结果中，减去其值，然后将余数转换为罗马数字。
 * 如果值以 4 或 9 开头，则使用 减法形式 ，表示从后面的符号中减去一个符号，例如，4 比 5（I）小 1（V）：IV 而 9 比 10（I）小 1（X）：。IX仅使用以下减法形式：4（IV）、9（IX）、40（XL）、90（XC）、400（CD）和 900（CM）。
 * 只能连续添加10 的幂（I、X、C、M），最多添加 3 次，以表示 10 的倍数。您不能多次添加 5 ( V)、50 ( L) 或 500 ( D)。如果需要添加 4 次符号，请使用减法形式。
 */
public class A18_12_intToRoman {


    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
        System.out.println(intToRoman(58));

    }



    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static String intToRoman2(int num) {
        //千位数
        String[] ths={"","M","MM","MMM"};

        //百位数
        String[] hrns = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};

        //十位数
        String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};

        //个位数
        String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};

        //千位数： 除以1000求商 ；；
        //百位：对1000求余 再除以100；；
        //十位：对100求余 再除以10；；
        //个位：对10 取余
        return ths[num / 1000] + hrns[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];

    }


    }
