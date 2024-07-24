package top150;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组prices，其中prices[i]包含当天某只股票的价格。ith
 *
 * 您希望通过选择某一天购买一只股票并选择未来的另一天卖出该股票来实现利润最大化。
 *
 * 返回本次交易您能获得的最大利润。如无法获得任何利润，则返回0
 */


public class A7_121_maxProfit {


    public static void main(String[] args) {
        System.out.println(maxProfit(new int []{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int []{7,6,4, 3,1}));

    }


    public static int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length == 1) return profit;
        int buy = prices[0];

        for(int i =  1; i < prices.length; i++){
            if(prices[i] < buy){
                buy = prices[i];
            }else{
                profit = Math.max(prices[i] - buy, profit);
            }
        }
        return profit;



    }

    //暴力
    public static int maxProfit1(int[] prices) {
        int w = 0;
        if(prices.length == 1) return w;
        for(int buy = 0; buy < prices.length - 1; buy++){
            if(buy > 0 && prices[buy] > prices[buy - 1]) continue;
            for(int sale = buy+1; sale < prices.length; sale++){
                if(prices[sale] < prices[buy] ) continue;
                w = Math.max(w, prices[sale] - prices[buy]);
            }
        }
        return w;
    }
}
