package binarytrees;

public class HasPathSum {

    public static boolean hasPathSum(BinaryTreeNode<Integer> root, int target) {
        return dfsForPathSum(root, 0, target);
    }

    private static boolean dfsForPathSum(BinaryTreeNode<Integer> node, int sum, int target) {
        if (node == null) return false;

        sum += node.data;

        if (node.left == null && node.right == null) return sum == target;
        return dfsForPathSum(node.left, sum, target)
                && dfsForPathSum(node.right, sum, target);
    }
}
