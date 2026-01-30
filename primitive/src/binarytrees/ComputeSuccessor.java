package binarytrees;

public class ComputeSuccessor {

    public static class BinaryTree<T> {
        public BinaryTree<T> parent, left, right;
        public T data;
    }

    public static BinaryTree<Integer> findSuccessor(BinaryTree<Integer> node) {
        BinaryTree<Integer> iter = node;

        if (iter.right != null) {
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        }

        while (iter.parent != null && iter.parent.right == iter) {
            iter = iter.parent;
        }
        return iter;
    }
}
