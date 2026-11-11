
class BSTNode {
    String data;
    BSTNode left, right;

    BSTNode(String value) {
        data = value;
        left = right = null;
    }
}

public class ProductCategoryBST {

    BSTNode root = null;

    // Insert a category
    void insert(String value) {
        root = insertNode(root, value);
    }

    BSTNode insertNode(BSTNode root, String value) {

        if (root == null) {
            return new BSTNode(value);
        }

        if (value.compareToIgnoreCase(root.data) < 0) {
            root.left = insertNode(root.left, value);
        }
        else if (value.compareToIgnoreCase(root.data) > 0) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    // Search a category
    boolean search(BSTNode root, String key) {

        if (root == null) {
            return false;
        }

        if (key.equalsIgnoreCase(root.data)) {
            return true;
        }

        if (key.compareToIgnoreCase(root.data) < 0) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Inorder: Left, Root, Right
    void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder: Root, Left, Right
    void preorder(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder: Left, Right, Root
    void postorder(BSTNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {

        ProductCategoryBST bst = new ProductCategoryBST();

        // 15 sample product categories
        String[] categories = {
            "Electronics",
            "Clothing",
            "Books",
            "Home",
            "Beauty",
            "Sports",
            "Toys",
            "Grocery",
            "Furniture",
            "Appliances",
            "Mobile",
            "Laptops",
            "Shoes",
            "Watches",
            "Kitchen"
        };

        // Insert all categories
        for (String category : categories) {
            bst.insert(category);
        }

        // Display traversals
        System.out.println("INORDER TRAVERSAL:");
        bst.inorder(bst.root);

        System.out.println("\n\nPREORDER TRAVERSAL:");
        bst.preorder(bst.root);

        System.out.println("\n\nPOSTORDER TRAVERSAL:");
        bst.postorder(bst.root);

        // Search category
        String key = "Mobile";

        System.out.println("\n\nSEARCH RESULT:");

        if (bst.search(bst.root, key)) {
            System.out.println(key + " found in BST");
        }
        else {
            System.out.println(key + " not found in BST");
        }
    }
}
