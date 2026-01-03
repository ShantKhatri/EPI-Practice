package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PermutationToArray {

    public static void main(String[] args) {

        // ---------- Test 1: Example from problem ----------
        List<Integer> A1 = new ArrayList<>(List.of(0, 1, 2, 3));
        List<Integer> P1 = new ArrayList<>(List.of(2, 0, 1, 3));
        applyPermutation(P1, A1);
        System.out.println("Test 1: " + A1 + " | Expected: [1, 2, 0, 3]");

        // ---------- Test 2: Identity permutation ----------
        List<Integer> A2 = new ArrayList<>(List.of(10, 20, 30, 40));
        List<Integer> P2 = new ArrayList<>(List.of(0, 1, 2, 3));
        applyPermutation(P2, A2);
        System.out.println("Test 2: " + A2 + " | Expected: [10, 20, 30, 40]");

        // ---------- Test 3: Reverse permutation ----------
        List<Integer> A3 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> P3 = new ArrayList<>(List.of(4, 3, 2, 1, 0));
        applyPermutation(P3, A3);
        System.out.println("Test 3: " + A3 + " | Expected: [5, 4, 3, 2, 1]");

        // ---------- Test 4: Single cycle ----------
        List<Integer> A4 = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> P4 = new ArrayList<>(List.of(1, 2, 3, 0));
        applyPermutation(P4, A4);
        System.out.println("Test 4: " + A4 + " | Expected: [4, 1, 2, 3]");

        // ---------- Test 5: Multiple disjoint cycles ----------
        List<Integer> A5 = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        List<Integer> P5 = new ArrayList<>(List.of(1, 0, 3, 2, 4));
        applyPermutationOpt(P5, A5);
        System.out.println("Test 5: " + A5 + " | Expected: [20, 10, 40, 30, 50]");

        // ---------- Test 6: Size = 1 ----------
        List<Integer> A6 = new ArrayList<>(List.of(99));
        List<Integer> P6 = new ArrayList<>(List.of(0));
        applyPermutationOpt(P6, A6);
        System.out.println("Test 6: " + A6 + " | Expected: [99]");

        // ---------- Test 7: Already permuted input ----------
        List<Integer> A7 = new ArrayList<>(List.of(3, 1, 4, 2));
        List<Integer> P7 = new ArrayList<>(List.of(2, 3, 1, 0));
        applyPermutationOpt(P7, A7);
        System.out.println("Test 7: " + A7 + " | Expected: [2, 4, 1, 3]");
    }

    // below is the worst solution
    public static void applyPermutation(List<Integer> perm, List<Integer> A) {
        HashMap<Integer, Integer> permMap = new HashMap<>();
        for (int i = 0; i < A.size(); ++i) {
            permMap.put(perm.get(i), i);
        }
//        System.out.println("Map: " + permMap);
        List<Integer> temp = new ArrayList<>(A);
        for (int i = 0; i< A.size(); ++i) {
            A.set(i, temp.get(permMap.get(i)));
        }
    }

    public static void applyPermutationOpt(List<Integer> perm, List<Integer> A) {
        for (int i = 0; i < A.size(); ++i) {
            int next = i;
            while(perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));
                int temp = perm.get(next);
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
    }


}
