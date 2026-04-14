class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BST {

    Node root;

    // Inserção
    public Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    // Busca
    public boolean search(Node root, int value) {
        if (root == null) return false;

        if (root.value == value) return true;

        if (value < root.value)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    // Remoção
    public Node remove(Node root, int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = remove(root.left, value);
        } else if (value > root.value) {
            root.right = remove(root.right, value);
        } else {

            // Caso 1: sem filhos
            if (root.left == null && root.right == null)
                return null;

            // Caso 2: um filho
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Caso 3: dois filhos
            Node successor = minValue(root.right);
            root.value = successor.value;
            root.right = remove(root.right, successor.value);
        }

        return root;
    }

    // Encontrar menor valor
    private Node minValue(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Altura da árvore
    public int height(Node root) {
        if (root == null) return -1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
