import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuySellStockOnce {

    public static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for(Double price : prices) {
            maxProfit = Math.max(maxProfit, price-minPrice);
            minPrice = Math.min(price, minPrice);
        }
        return maxProfit;
    }

    public static int subArray(List<Integer> array) {
        int length = 1, maxLength = 1;
        for (int i = 1; i < array.size()-1; i++) {
            if (array.get(i) != array.get(i-1)) {
                length=1;
            }
            else
                length++;
            System.out.println("length: "+length);
            System.out.println("Index: " + i + " Value at index: " + array.get(i));
            maxLength = Math.max(length, maxLength);
            System.out.println("MaxLength: "+ maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(computeMaxProfit(Arrays.asList(0.0,5.0,0.0, 20.0,0.0,10.0,30.,0.0, 25.0, 20.0)));
        System.out.println(subArray(Arrays.asList(0,1,1,1,2,3,2,3,1,1,1,1,2,2)));
    }
}
