package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SampleOnlineData {
    // O(k) time complexity
    public static List<Integer> onlineRandomSamle(Iterator<Integer> sequence, int k) {
        List<Integer> runningSample = new ArrayList<>(k);
        for (int i = 0; i < k && sequence.hasNext(); ++i) {
            runningSample.add(sequence.next());
        }

        int numSeenSoFar = k;
        Random randIdxGen = new Random();
        while(sequence.hasNext()) {
            Integer x = sequence.next();
            ++numSeenSoFar;
            final int idxToReplace = randIdxGen.nextInt(numSeenSoFar);
            if (idxToReplace < k) {
                runningSample.set(idxToReplace, x);
            }
        }
        return runningSample;
    }
}
