package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuySellStockTwice {

    public static double buyAndSellStockTwice(List<Double> prices) {
        double maxProfit= 0.0;
        List<Double> firstBuySellProfit = new ArrayList<>();
        double minPriceSoFar = Double.MAX_VALUE;

        for (int i = 0; i < prices.size()-1; i++) {
            minPriceSoFar = Math.min(minPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, prices.get(i) - minPriceSoFar);
            firstBuySellProfit.add(maxProfit);
        }

        double maxPriceSoFar = Double.MIN_VALUE;
        for (int i = prices.size()-1; i >0 ; --i) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, maxPriceSoFar - prices.get(i) + firstBuySellProfit.get(i-1));
        }
        return maxProfit;
    }

    public static double buyAndSellStockTwiceOpt(List<Double> prices) {
        double buy1 = Double.NEGATIVE_INFINITY;
        double sell1 = 0.0;
        double buy2 = Double.NEGATIVE_INFINITY;
        double sell2 = 0.0;

        for (double price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1+price);
            buy2 = Math.max(buy2, sell1-price);
            sell2 = Math.max(sell2, buy2+price);
        }
        return sell2;
    }

    public static void main(String[] args) {
        System.out.println(buyAndSellStockTwice(Arrays.asList(0.0,5.0,0.0, 20.0,0.0,10.0,30.,0.0, 25.0, 20.0)));
        System.out.println(buyAndSellStockTwiceOpt(Arrays.asList(0.0,5.0,0.0, 20.0,0.0,10.0,30.,0.0, 25.0, 20.0)));
    }
}
