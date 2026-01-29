package binarytrees;

import java.util.ArrayList;
import java.util.List;

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

    public static List<List<Integer>> pathWithTargetSum(BinaryTreeNode<Integer> root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        pathWithTargetSumHelper(root, 0, target, new ArrayList<>(), result);
        return result;
    }

    private static void pathWithTargetSumHelper(BinaryTreeNode<Integer> node,
                                                int sum,
                                                int target,
                                                List<Integer> curr_list,
                                                List<List<Integer>> result) {
        if (node == null) return;

        sum += node.data;
        curr_list.add(node.data);
        if (node.left == null && node.right == null) {
            if (sum == target) result.add(new ArrayList<>(curr_list));
        } else {
            pathWithTargetSumHelper(node.left, sum, target, curr_list, result);
            pathWithTargetSumHelper(node.right, sum, target, curr_list, result);
        }

        curr_list.removeLast();
    }
}
