package binarytrees;

public class LCABTWithParentPointers {

    public static class BinaryTreeNode<T> {
        public T data;
        public binarytrees.BinaryTreeNode<T> left;
        public binarytrees.BinaryTreeNode<T> right;
        public BinaryTreeNode<Integer> parent;
    }

    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> node0,
                                              BinaryTreeNode<Integer> node1) {
        int depth0 = getDepth(node0), depth1 = getDepth(node1);
        if (depth1 > depth0) {
            BinaryTreeNode<Integer> tmp = node0;
            node0 = node1;
            node1 = tmp;
        }

        int depthDiff = Math.abs(depth0 - depth1);

        while (depthDiff-- > 0) {
            node0 = node0.parent;
        }

        while (node0 != node1) {
            node0 = node0.parent;
            node1 = node1.parent;
        }

        return node0;
    }

    private static int getDepth(BinaryTreeNode<Integer> node) {
        int depth = 0;
        while (node.parent != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
