package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalWithO1Space {

    public static List<Integer> inorderTraversal(ComputeSuccessor.BinaryTree<Integer> tree) {
        ComputeSuccessor.BinaryTree<Integer> prev = null, curr = tree;
        List<Integer> result = new ArrayList<>();

        while (curr != null) {
            ComputeSuccessor.BinaryTree<Integer> next;
            if (curr.parent == prev) {
                if (curr.left != null) {
                    next = curr.left;
                } else {
                    result.add(curr.data);
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                result.add(curr.data);
                next = (curr.right != null) ? curr.right : curr.parent;
            } else {
                next = curr.parent;
            }

            prev = curr;
            curr = next;
        }

        return result;
    }

    public static List<Integer> inorderTraversalUsingSuccessor(ComputeSuccessor.BinaryTree<Integer> tree) {
        ComputeSuccessor.BinaryTree<Integer> iter = tree;
        List<Integer> result = new ArrayList<>();
        while (iter.left!= null) {
            iter = iter.left;
        }
        do {
            result.add(iter.data);
            iter = ComputeSuccessor.findSuccessor(iter);
        } while (iter != null);
        return result;
    }
}
