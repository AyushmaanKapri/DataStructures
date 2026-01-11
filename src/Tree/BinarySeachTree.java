package Tree;

public class BinarySeachTree {

    // ---------- INSERT ----------
    static Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    // ---------- SEARCH ----------
    static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // ---------- HEIGHT ----------
    static int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // ---------- INORDER PREDECESSOR ----------
    static Node inPre(Node root) {
        while (root != null && root.right != null)
            root = root.right;
        return root;
    }

    // ---------- INORDER SUCCESSOR ----------
    static Node inSuc(Node root) {
        while (root != null && root.left != null)
            root = root.left;
        return root;
    }

    // ---------- DELETE ----------
    static Node delete(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Node found
            if (root.left == null && root.right == null)
                return null;

            if (height(root.left) > height(root.right)) {
                Node q = inPre(root.left);
                root.data = q.data;
                root.left = delete(root.left, q.data);
            } else {
                Node q = inSuc(root.right);
                root.data = q.data;
                root.right = delete(root.right, q.data);
            }
        }
        return root;
    }

    // ---------- TRAVERSALS ----------
    static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);

        System.out.println("Search 20: " + search(root, 20));

        System.out.print("Preorder: ");
        preOrder(root);

        root = delete(root, 30);

        System.out.print("\nPreorder after delete: ");
        preOrder(root);

        System.out.print("\nInorder: ");
        inOrder(root);

        System.out.print("\nPostorder: ");
        postOrder(root);
    }
}
