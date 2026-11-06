
public class BinarySearchTree {

    Node root;

    // Insert a new value
    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node root, int data) {

        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }

        return root;
    }

    // Search for a value
    public boolean search(int data) {
        return searchNode(root, data);
    }

    private boolean searchNode(Node root, int data) {

        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if (data < root.data) {
            return searchNode(root.left, data);
        }

        return searchNode(root.right, data);
    }

    // Delete a value
    public void delete(int data) {
        root = deleteNode(root, data);
    }

    private Node deleteNode(Node root, int data) {

        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            root.data = findMinimum(root.right);
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    // Find minimum value
    private int findMinimum(Node root) {

        int minimum = root.data;

        while (root.left != null) {
            minimum = root.left.data;
            root = root.left;
        }

        return minimum;
    }

    // Inorder traversal
    public void inorder(Node root) {

        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder traversal
    public void preorder(Node root) {

        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder traversal
    public void postorder(Node root) {

        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public Node getRoot() {
        return root;
    }
}
