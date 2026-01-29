package binarytrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversalWithoutRecursion {

    // Time and space complexity is O(n) and O(h) respectively.
    public static List<Integer> preorderTraversal(BinaryTreeNode<Integer> root) {
        Deque<BinaryTreeNode<Integer>> path = new LinkedList<>();
        path.addFirst(root);
        List<Integer> result = new ArrayList<>();

        while(!path.isEmpty()) {
            BinaryTreeNode<Integer> curr = path.removeFirst();
            if (curr != null) {
                result.add(curr.data);
                path.addFirst(curr.right);
                path.addLast(curr.left);
            }
        }
        return result;
    }
}
