package Arrays;

import java.util.*;

public class ComputeRandomSubset {

    public static List<Integer> randomSubset(int n, int k) {
        Map<Integer, Integer> changedElements = new HashMap<>();
        Random randIdxGen = new Random();
        for (int i = 0; i < k; ++i) {
            int randIdx = randIdxGen.nextInt(n-1);
            Integer ptr1 = changedElements.get(randIdx);
            Integer ptr2 = changedElements.get(i);

            if (ptr1 == null && ptr2 == null) {
                changedElements.put(i, randIdx);
                changedElements.put(randIdx, i);
            } else if(ptr1 == null && ptr2 != null) {
                changedElements.put(randIdx, ptr2);
                changedElements.put(i, randIdx);
            } else if(ptr1 != null && ptr2 == null) {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, i);
            } else {
                changedElements.put(randIdx, ptr2);
                changedElements.put(i, ptr1);
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            result.add(changedElements.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(randomSubset(100, 4));
    }
}
