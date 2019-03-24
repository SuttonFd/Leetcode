package xin.suttonprog.Arrays;

/**
 * Tags:Array Greedy(贪心)
 * @author codingZhengsz
 * @since 2019-03-24 13:15
 **/
public class _122BestTimeToBuyAndSellStockII {

    /**
     * Runtime: 1 ms, faster than 79.49%
     * Memory Usage: 38 MB, less than 70.24%
     */
    public int maxProfit_PeakValleyApproach(int[] prices) {
        int length = prices.length;
        if(length < 1) return 0;
        int peak = prices[0],valley = prices[0];
        int maxProfix = 0;
        int i = 0;
        while(i < length-1) {
            while(i < length - 1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley = prices[i];
            while(i < length - 1 && prices[i] <= prices[i+1]){
                i++;
            }
            peak = prices[i];
            maxProfix += peak - valley;
        }
        return maxProfix;
    }

    /**
     * Runtime: 1 ms, faster than 79.49%
     * Memory Usage: 35.7 MB, less than 93.70%
     */
    public int maxProfit_SimpleOnePass(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        if(length < 1) return 0;
        for(int i = 1; i < length; i++) {
            if(prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new _122BestTimeToBuyAndSellStockII().maxProfit_PeakValleyApproach(new int[]{7,1,5,3,6,4}));
    }
}
