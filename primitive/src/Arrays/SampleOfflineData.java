package Arrays;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleOfflineData {

    public static void randomSampling(int k, List<Integer> A) {
        Random gen = new Random();
        for (int i = 0; i < k; i++) {
            Collections.swap(A, i, i + gen.nextInt(A.size() - i));
        }
    }
}
