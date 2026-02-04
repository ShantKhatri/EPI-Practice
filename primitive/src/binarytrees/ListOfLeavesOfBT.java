package binarytrees;

import java.util.LinkedList;
import java.util.List;

public class ListOfLeavesOfBT {

    public static List<BinaryTreeNode<Integer>> createListLeaves(BinaryTreeNode<Integer> tree) {
        List<BinaryTreeNode<Integer>> leaves = new LinkedList<>();
        addLeavesLeftToRight(tree, leaves);
        return leaves;
    }

    private static void addLeavesLeftToRight(BinaryTreeNode<Integer> tree, List<BinaryTreeNode<Integer>> leaves) {
        if (tree != null) {
            if (tree.left == null && tree.right == null) {
                leaves.add(tree);
            } else {
                addLeavesLeftToRight(tree.left, leaves);
                addLeavesLeftToRight(tree.right, leaves);
            }
        }
    }
}
