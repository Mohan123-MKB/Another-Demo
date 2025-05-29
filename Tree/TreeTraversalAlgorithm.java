package Tree;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class TreeTraversalAlgorithm {
    TreeNode root;

    // Insert nodes in level-order
    public void insert(int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur.left == null) {
                cur.left = newNode;
                break;
            } else {
                q.add(cur.left);
            }

            if (cur.right == null) {
                cur.right = newNode;
                break;
            } else {
                q.add(cur.right);
            }
        }
    }

    // In-order Traversal: Left -> Root -> Right
    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    // Pre-order Traversal: Root -> Left -> Right
    void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Post-order Traversal: Left -> Right -> Root
    void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        TreeTraversalAlgorithm tree = new TreeTraversalAlgorithm();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            tree.insert(value);
        }

        sc.close(); // Close scanner to prevent resource leak

        System.out.println("\nIn-order Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPre-order Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPost-order Traversal:");
        tree.postorder(tree.root);
    }
}
