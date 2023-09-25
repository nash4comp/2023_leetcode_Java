package Trees;

public class MyBinaryTree {
    public static final String IN_ORDER_TRAVERSE = "inorder";
    public static final String PRE_ORDER_TRAVERSE = "preorder";
    public static final String POST_ORDER_TRAVERSE = "postorder";
    private TreeNode root;
    private int nodeCounter = 0;

    private class TreeNode {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public TreeNode getLeftNode() {
            return leftChild;
        }

        public void setLeftNode(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightNode() {
            return rightChild;
        }

        public void setRightNode(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public int getData() {
            return data;
        }
    }

    public boolean search(int data) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                return true;
            } else if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        return false;
    }

    public boolean addData(int data) {
        TreeNode newNode = new TreeNode(data);
        if (search(data)) {
            return false;
        }

        if (root == null) {
            root = newNode;
            nodeCounter++;
            return true;
        }

        TreeNode currentNode = root;
        TreeNode parentNode;

        while (true) {
            parentNode = currentNode;
            if (data < currentNode.getData()) {
                currentNode = currentNode.getLeftNode();
                if (currentNode == null) {
                    parentNode.setLeftNode(newNode);
                    nodeCounter++;
                    return true;
                }
            } else if (data > currentNode.getData()) {
                currentNode = currentNode.getRightNode();
                if (currentNode == null) {
                    parentNode.setRightNode(newNode);
                    nodeCounter++;
                    return true;
                }
            }
        }

    }

    public TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        // 왼쪽과 오른쪽 자식 노드를 바꾼다.
        TreeNode temp = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = temp;

        // 왼쪽과 오른쪽 서브트리도 뒤집는다.
        invertTree(node.leftChild);
        invertTree(node.rightChild);

        return node;
    }

    public void invertAndPrintTree() {
        System.out.println("Before inverted Tree: ");
        printNode(IN_ORDER_TRAVERSE);
        root = invertTree(root);
        System.out.println("Inverted Tree: ");
        printNode(IN_ORDER_TRAVERSE);
        System.out.println();
    }

    // A
    // B C
    //
    // in-order: follow the order from left to right, B A C
    // pre-order: read root first and follow the order from left to right: A B C
    // post-order: read root last and follow the order from left to right: B C A

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeftNode());
        System.out.printf("%d ", node.getData());
        inOrderTraversal(node.getRightNode());
    }

    private void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d ", node.getData());
        preOrderTraversal(node.getLeftNode());
        preOrderTraversal(node.getRightNode());
    }

    private void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeftNode());
        postOrderTraversal(node.getRightNode());
        System.out.printf("%d ", node.getData());
    }

    public int getNodeCounter() {
        return nodeCounter;
    }

    public void printNode(String mode) {
        switch (mode) {
            case PRE_ORDER_TRAVERSE:
                preOrderTraversal(root);
                System.out.println("\n" + getNodeCounter());
                break;
            case POST_ORDER_TRAVERSE:
                postOrderTraversal(root);
                System.out.println("\n" + getNodeCounter());
                break;
            case IN_ORDER_TRAVERSE:
            default:
                inOrderTraversal(root);
                System.out.println("\n" + getNodeCounter());
                break;
        }
    }

    public static void main(String[] args) {
        MyBinaryTree myBT = new MyBinaryTree();
        int[] data = { 25, 15, 10, 4, 12, 22, 18, 24, 31, 35, 44, 70, 66, 90 };

        for (int value : data) {
            myBT.addData(value);
        }

        System.out.println(IN_ORDER_TRAVERSE);
        myBT.printNode(IN_ORDER_TRAVERSE);
        System.out.println();

        System.out.println(PRE_ORDER_TRAVERSE);
        myBT.printNode(PRE_ORDER_TRAVERSE);
        System.out.println();

        System.out.println(POST_ORDER_TRAVERSE);
        myBT.printNode(POST_ORDER_TRAVERSE);
        System.out.println();

        myBT.invertAndPrintTree();

    }

}
