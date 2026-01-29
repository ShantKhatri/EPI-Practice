package binarytrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversalWithoutRecursion {

    // Time and Space complexity is O(n) and O(h) respectively.
    public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> tree) {
        Deque<BinaryTreeNode<Integer>> s = new LinkedList<>();
        BinaryTreeNode<Integer> curr = tree;
        List<Integer> result = new ArrayList<>();

        while(!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.addFirst(curr);
                curr = curr.left;
            } else {
                curr = s.removeFirst();
                result.add(curr.data);
                curr = curr.right;
            }
        }

        return result;
    }
}
