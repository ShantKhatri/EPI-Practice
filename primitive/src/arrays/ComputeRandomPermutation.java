package arrays;

import java.util.ArrayList;
import java.util.List;

public class ComputeRandomPermutation {

    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> permutation = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            permutation.add(i);
        }
        SampleOfflineData.randomSampling(permutation.size(), permutation);
        return permutation;
    }
}
