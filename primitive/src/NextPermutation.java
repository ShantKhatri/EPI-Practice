import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static List<Integer> nextPermutation(List<Integer> array) {
        int k = array.size() - 2;
        while(k>=0 && array.get(k) >= array.get(k+1))
            --k;
        if (k==-1)
            return Collections.emptyList();
        for (int i = array.size()-1; i>k; --i) {
            if (array.get(i) > array.get(k)) {
                Collections.swap(array, k, i);
                break;
            }
        }
        Collections.reverse(array.subList(k+1, array.size()));
        return array;
    }

    public static List<Integer> prevPermutation(List<Integer> array) {
        int k = array.size() - 2;
        while(k>=0 && array.get(k) <= array.get(k+1))
            --k;
        if (k-1<=0)
            return Collections.emptyList();
        for (int i = array.size()-1; i>k; --i) {
            if (array.get(i) < array.get(k)) {
                Collections.swap(array, k, i);
                break;
            }
        }
        Collections.reverse(array.subList(k+1, array.size()));
        return array;
    }

    public static List<Integer> permutationFromRank(List<Integer> base, long rank) {
        int n = base.size();
        List<Integer> numbers = new ArrayList<>(base);
        Collections.sort(numbers);

        long[] fact = new long[n+1];
        fact[0] = 1;
        for (int i = 0; i <= n; i++) fact[i] = fact[i-1] * i;

        List<Integer> result = new ArrayList<>();

        for (int i = n; i >= 1; i--) {
            int idx = (int)(rank / fact[i-1]);
            rank %= fact[i-1];
            result.add(numbers.remove(idx));
        }
        return result;
    }

    public static long permutationRank(List<Integer> perm) {
        int n = perm.size();
        long rank = 0;

        long[] fact = new long[n+1];
        fact[0] = 1;
        for (int i = 0; i <= n; i++) fact[i] = fact[i-1] * i;

        for (int i = 0; i < n; i++){
            int countSmaller = 0;
            for (int j = 0; j < n; j++) {
                if (perm.get(j) < perm.get(i)) {
                    countSmaller++;
                }
            }
            rank += countSmaller * fact[n-i-1];
        }
        return rank;
    }
}
