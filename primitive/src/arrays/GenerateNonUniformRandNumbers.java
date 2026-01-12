package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateNonUniformRandNumbers {

    public static int nonuniformRandomNumberGenerator(List<Integer> values, List<Double> probabilities) {
        List<Double> psp = new ArrayList<>();
        psp.add(0.0);
        for (Double p : probabilities)
            psp.add(psp.get(psp.size()-1));
        Random r = new Random();
        final Double uniform01 = r.nextDouble();
        int it = Collections.binarySearch(psp, uniform01);
        if (it < 0) {
            final int intervalIdx = (Math.abs(it)-1)-1;
            return values.get(intervalIdx);
        } else {
            return values.get(it);
        }
    }
}
