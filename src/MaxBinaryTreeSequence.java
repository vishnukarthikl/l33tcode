import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaxBinaryTreeSequence {
    private Map<TreeNode, Integer> sequenceLength = new HashMap<>();

    public int longestConsecutive(TreeNode root) {
        recurse(root);
        return findMax(root);
    }

    private int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (isLeaf(node)) {
            return sequenceLength.get(node);
        } else {
            return Math.max(getLength(node), Math.max(findMax(node.left), findMax(node.right)));
        }
    }

    private Integer getLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return sequenceLength.get(node);
    }

    private int recurse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            sequenceLength.put(node, 1);
            return 1;
        } else {
            int leftLength = getChildLength(node, node.left);
            int rightLength = getChildLength(node, node.right);
            int max = Math.max(leftLength, rightLength);
            sequenceLength.put(node, max);
            return max;
        }
    }

    private int getChildLength(TreeNode parent, TreeNode child) {
        if (child == null) {
            return 0;
        }

        int length = recurse(child);
        if ((parent.val + 1 == child.val)) {
            return length + 1;
        } else {
            return 1;
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}