package LeetCode.Easy;

public class BuyAndSellStock {

    public int maxProfit1(int[] prices) {
        int runningMin = prices[0];
        int runningMax = prices[0];
        int runningDiff = -1;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < runningMin) {
                runningMin = price;
                runningMax = price;
            }
            if (price > runningMax) {
                runningDiff = runningMax - runningMin;
                runningMax = price;
            }
        }
        return runningDiff;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
