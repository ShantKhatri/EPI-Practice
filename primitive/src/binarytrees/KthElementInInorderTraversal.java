package binarytrees;

//Problem: Write a program that efficiently computes the kth node appearing in an inorder
//  traversal. "Assume that each node storesthe number of nodesin the subtree rooted at
//  that node".
public class KthElementInInorderTraversal {

    public static class BTNode<T> extends binarytrees.BinaryTreeNode<T> {
        public BTNode<T> left, right;
        public static int size;
    }
    // Time and space complexity is O(n) and O(h) respectively.
    public static BTNode<Integer> findKthNodeBinaryTree(BTNode<Integer> tree, int k) {
        BTNode<Integer> iter = tree;
        while (iter!=null) {
            int leftSize = iter.left != null ? iter.left.size : 0;
            if (leftSize + 1 < k) {
                k -= leftSize + 1;
                iter = iter.right;
            } else if (leftSize == k - 1) {
                return iter;
            } else {
                iter = iter.left;
            }
        }
        return null;
    }
}
