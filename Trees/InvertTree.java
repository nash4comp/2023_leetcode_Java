package Trees;

public class InvertTree {
    public static final String IN_ORDER_TRAVERSE = "inorder";
    public static final String PRE_ORDER_TRAVERSE = "preorder";
    public static final String POST_ORDER_TRAVERSE = "postorder";
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        int[] data = { 4, 2, 7, 1, 3, 6, 9 };
        for (int value : data) {
            tree.addData(value);
        }

        tree.printNode(IN_ORDER_TRAVERSE);

    }


}

// class Solution {

//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) return null;
//         TreeNode node = new TreeNode(root.val);
//         node.right = invertTree(root.left);
//         node.val = root.val;
//         node.left = invertTree(root.right);
//         return node;
//     }
// }

