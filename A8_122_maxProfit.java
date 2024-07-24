package top150;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个整数数组，prices其中prices[i]表示当天某只股票的价格。ith
 * 每天，您都可以决定买入或卖出股票。您最多只能在任何时候持有一股股票。但是，您可以买入后在同一天立即卖出。
 *
 * 寻找并返回您可以实现的最大利润。
 * 示例 1：
 *
 * 输入： prices = [7,1,5,3,6,4]
 * 输出： 7
 * 解释：第 2 天买入（价格 = 1），第 3 天卖出（价格 = 5），利润 = 5-1 = 4。
 * 然后在第 4 天（价格 = 3）买入，在第 5 天（价格 = 6）卖出，利润 = 6-3 = 3。
 * 总利润为4+3=7。
 * 示例 2：
 *
 * 输入： prices = [1,2,3,4,5]
 * 输出： 4
 * 解释：第 1 天买入（价格 = 1），第 5 天卖出（价格 = 5），利润 = 5-1 = 4。
 * 总利润为4。
 * 示例 3：
 *
 * 输入： prices = [7,6,4,3,1]
 * 输出： 0
 * 解释：没有办法获得正利润，所以我们永远不会购买股票以实现最大利润 0。
 *
 */


public class A8_122_maxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length == 1) return profit;
        int buy = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > buy){
                profit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return profit;
    }
}
