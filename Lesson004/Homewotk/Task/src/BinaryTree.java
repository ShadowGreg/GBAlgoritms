public class BinaryTree {
    Node root;

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Метод для добавления нового узла в дерево
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Рекурсивный метод для добавления нового узла в дерево
    private Node insertRec(Node root, int key) {
        // Если дерево пустое, создаем новый узел
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Иначе рекурсивно спускаемся в дерево
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Возвращаем измененный узел
        return root;
    }

    // Метод для вывода дерева в порядке in-order
    public void inorder() {
        inorderRec(root);
    }

    // Рекурсивный метод для вывода дерева в порядке in-order
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}
