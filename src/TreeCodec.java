import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TreeCodec {

    private static final String SPLIT = ",";
    private static final String NULL = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        recursiveSerialize(root, serialized);
        return serialized.toString();
    }

    private void recursiveSerialize(TreeNode node, StringBuilder serialized) {
        if (node == null) {
            serialized.append(NULL).append(SPLIT);
        } else {
            serialized.append(node.val).append(SPLIT);
            recursiveSerialize(node.left, serialized);
            recursiveSerialize(node.right, serialized);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return recursiveDeSerialize(nodes);
    }

    private TreeNode recursiveDeSerialize(Deque<String> nodes) {
        String node = nodes.remove();
        if (node.equals(NULL)) {
            return null;
        } else {
            TreeNode treeNode = new TreeNode(Integer.valueOf(node));
            treeNode.left = recursiveDeSerialize(nodes);
            treeNode.right = recursiveDeSerialize(nodes);
            return treeNode;
        }
    }
}