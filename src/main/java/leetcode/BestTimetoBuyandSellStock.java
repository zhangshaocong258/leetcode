package leetcode;

/**
 * Created by zsc on 2017/8/31.
 * 买卖股票
 */
public class BestTimetoBuyandSellStock {
    public static void main(String arg[]) {
        solution121 solution121 = new solution121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution121.maxProfit(prices));
    }
}

class solution121 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int cur = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            cur = Math.max(cur, -prices[i]);
            result = Math.max(prices[i] + cur, result);
        }
        return result;
    }
}