package binarytrees;

import javax.print.DocFlavor;

public class SumRootToLeafBT {

    public static int sumRootToLeaf(BinaryTreeNode<Integer> tree) {
        return sumRootToLeafHelper(tree, 0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialPathSum) {
        if (tree == null) return 0;

        partialPathSum = partialPathSum * 2 + tree.data;
        if (tree.left == null && tree.right == null) return partialPathSum;

        return sumRootToLeafHelper(tree.left, partialPathSum)
                + sumRootToLeafHelper(tree.right, partialPathSum);
    }
}
