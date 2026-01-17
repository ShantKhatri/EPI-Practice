package binarytrees;

import java.util.Objects;

public class TestBinaryTreeSymmetry {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else if (!Objects.equals(left.data, right.data)) return false;
        else {
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        }
    }
}
