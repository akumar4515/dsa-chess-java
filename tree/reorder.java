package tree;

public class reorder {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int idx = 0;

        public static Node buildTree(int[] data) {
            if (idx >= data.length || data[idx] == -1) {
                idx++;
                return null;
            }

            Node newNode = new Node(data[idx]);
            idx++;

            newNode.left = buildTree(data);
            newNode.right = buildTree(data);

            return newNode;
        }

        public static void preorderTraversal(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int data[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Node root = BinaryTree.buildTree(data);

        System.out.println("Preorder Traversal:");
        BinaryTree.preorderTraversal(root);
    }
}
