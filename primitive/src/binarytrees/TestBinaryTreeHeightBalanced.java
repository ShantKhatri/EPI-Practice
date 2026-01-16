package binarytrees;

import java.util.function.BinaryOperator;

public class TestBinaryTreeHeightBalanced {
    public static class BalancedStatusWIthHeight {
        public boolean balanced;
        public int height;

        public BalancedStatusWIthHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
        return checkBalanced(tree).balanced;
    }

    private static BalancedStatusWIthHeight checkBalanced(BinaryTreeNode<Integer> tree) {
        if (tree == null) return new BalancedStatusWIthHeight(true, -1);

        BalancedStatusWIthHeight leftResult = checkBalanced(tree.left);
        if (!leftResult.balanced) {
            return leftResult;
        }
        BalancedStatusWIthHeight rightResult = checkBalanced(tree.right);
        if (!rightResult.balanced) {
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalancedStatusWIthHeight(isBalanced, height);
    }

}


