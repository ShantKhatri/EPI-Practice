package binarytrees;

import javax.swing.tree.TreeNode;
import java.util.*;

public class SamplePractice {
    public static List<Integer> inOrderTraversal(BinaryTreeNode<Integer> root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        result.addAll(inOrderTraversal(root.left));
        result.add(root.data);
        result.addAll(inOrderTraversal(root.right));
        return result;
    }

    public static List<Integer> preOrderTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.data);
        result.addAll(preOrderTraversal(root.left));
        result.addAll(preOrderTraversal(root.right));
        return result;
    }

    public static List<Integer> postOrderTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.addAll(postOrderTraversal(root.left));
        result.addAll(postOrderTraversal(root.right));
        result.add(root.data);
        return result;
    }

    public static int countNodeInBinaryTree(BinaryTreeNode<Integer> root) {
        if (root.left == null && root.right == null) return 1;
        else if (root.left == null) return countNodeInBinaryTree(root.right);
        else if (root.right == null) return countNodeInBinaryTree(root.left);
        else return countNodeInBinaryTree(root.left) + countNodeInBinaryTree(root.right);
    }

    public static int heightOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        return Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)) + 1;
    }

    public static int countLeafNodesInBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        return countLeafNodesInBinaryTree(root.left) + countLeafNodesInBinaryTree(root.right);
    }

    public static BinaryTreeNode<Integer> searchInBinaryTree(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;

        BinaryTreeNode<Integer> left = searchInBinaryTree(root.left, target);
        if (left != null) return left;

        return searchInBinaryTree(root.right, target);
    }

    public static BinaryTreeNode<Integer> invertBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) return null;


        BinaryTreeNode<Integer> left = invertBinaryTree(root.left);
        BinaryTreeNode<Integer> right = invertBinaryTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static boolean isIdentical(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (!Objects.equals(p.data, q.data)) return false;
        return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        return isSymetricHelper(root.left, root.right);
    }

    private static boolean isSymetricHelper(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (!Objects.equals(left.data, right.data)) return false;
        return isSymetricHelper(left.right, right.left) && isSymetricHelper(left.left, right.right);
    }

    public static int countNodesAtLevelK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) return 0;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (level == k) return size;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return 0;
    }

    public static List<Integer> levelOrderTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
//        result.add(root.data);
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            result.add(current.data);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return result;
    }

    public static int sumOfAllNodes(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        return root.data + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
    }

    public static int maxValInBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maxValInBinaryTree(root.left), maxValInBinaryTree(root.right)));
    }

    public static boolean isHeightBalanced(BinaryTreeNode<Integer> root) {
        return heightBalancedHelper(root) != -1;
    }

    private static int heightBalancedHelper(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;

        int left = heightBalancedHelper(root.left);
        if (left == -1) return - 1;

        int right = heightBalancedHelper(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return - 1;

        return Math.max(left, right) + 1;
    }

    public static List<String> binaryTreePath(BinaryTreeNode<Integer> root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfsForBTPath(root, "", result);
        return result;
    }

    private static void dfsForBTPath(BinaryTreeNode<Integer> node, String path, List<String> result) {
        if (node == null) return;

        //build current path
        path = path.isEmpty() ? String.valueOf(node.data) : path + "->" + node.data;

        // if leaf node, add path
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        dfsForBTPath(node.left, path, result);
        dfsForBTPath(node.right, path, result);
    }

    public static boolean hasPathSum(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return false;
        return dfsForHasPathSum(root, 0, target);
    }

    private static boolean dfsForHasPathSum(BinaryTreeNode<Integer> node, int sum, int target) {
        if (node == null) return false;

        sum += node.data;

        if (node.left == null && node.right == null) return sum == target;
        return dfsForHasPathSum(node.left, sum, target) ||
                dfsForHasPathSum(node.right, sum, target);
    }

    private static int diameter;
    public static int diameterOfTree(BinaryTreeNode<Integer> root) {
        diameter = 0;
        dmtHeightHelper(root);
        return diameter;
    }

    private static int dmtHeightHelper(BinaryTreeNode<Integer> node) {
        if (node == null) return 0;


        int leftHeight = dmtHeightHelper(node.left);
        int rightHeight = dmtHeightHelper(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;

        if (target < root.data) {
            return  searchInBST(root.left, target);
        } else if (target > root.data) {
            return searchInBST(root.right, target);
        } else  {
            return root;
        }
    }

    public static boolean isValidBST(BinaryTreeNode<Integer> root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(BinaryTreeNode<Integer> node, long min, long max) {
        if (node == null) return true;

        if (node.data <= min || node.data >= max) return false;

        return isValidBST(node.left, min, node.data)
                && isValidBST(node.right, node.data, max);
    }

    public static List<List<Integer>> zigzagLevelOrderTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = queue.poll();
                if (leftToRight) level.addLast(node.data);
                else {
                    level.addFirst(node.data);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static List<Integer> rightSideViewBT(BinaryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = queue.poll();
                if (i == size - 1) result.add(node.data);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }



}
