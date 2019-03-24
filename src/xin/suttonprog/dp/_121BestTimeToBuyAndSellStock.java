package xin.suttonprog.dp;

/**
 * 121. Best Time to Buy and Sell Stock
 * @author codingZhengsz
 * @since 2019-03-24 12:30
 **/
public class _121BestTimeToBuyAndSellStock {

    /**
     * 动态规划
     * 用一个数组保存当前最小的价格
     * 用一个数组保存当前最大的收益
     * Runtime: 1 ms, faster than 82.97%
     * Memory Usage: 35.8 MB, less than 92.84%
     */
    public int maxProfit_dp(int[] prices) {
        int length = prices.length;
        if(length < 1) return 0;
        int[] min_prices = new int[length];
        int[] max_profit = new int[length];
        min_prices[0] = prices[0];
        max_profit[0] = 0;
        for(int i=1;i<length;i++) {
            min_prices[i] = Math.min(min_prices[i-1],prices[i]);
            max_profit[i] = Math.max(max_profit[i-1],prices[i] - min_prices[i-1]);
        }
        return max_profit[length - 1];
    }

    /**
     * 每一天出现的新价格，先判断这个价格减去之前选择买进的价格是否比之前的收益要大
     * 以及这个新的价格是否比之前买入的价格低
     * 如果收益更大，将当前的收益记录下来，存为目前的最大收益
     * 如果价格更低，将当前的价格记录下来，存为当前的最低价格
     * Runtime: 1 ms, faster than 82.97%
     * Memory Usage: 37.9 MB, less than 69.86%
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrices = 0;
        int length = prices.length;
        if(length < 1) return 0;
        minPrices = prices[0];
        for(int i = 1;i< length;i++) {
            maxProfit = Math.max(maxProfit,prices[i] - minPrices);
            minPrices = Math.min(minPrices,prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new _121BestTimeToBuyAndSellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }


}
