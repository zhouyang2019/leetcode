package com.zy.tree;

/**
 * 构造二叉树
 */
public class BuildTree {

    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     *
     * For example, given
     *
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length < 1 || (postorder.length < 1)) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        if (l1 > r1 || (l2 > r2)) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r2]);
        int offset = 0;
        for (int i = 0; i <= r1 - l1; i++) {
            if (inorder[l1 + i] == root.val) {
                offset = i;
            }
        }
        root.left = build(inorder, l1, l1 + offset - 1, postorder, l2, l2 + offset - 1);
        root.right = build(inorder, l1 + offset + 1, r1, postorder, l2 + offset, r2 - 1);
        return root;
    }

    /**
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode buildTreeByPre(int[] preorder, int[] inorder) {
        if (inorder.length < 1 || (preorder.length < 1)) {
            return null;
        }
        return buildTreeByPreInternal(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeByPreInternal(int[] inorder, int l1, int r1, int[] preorder, int l2, int r2) {
        if (l1 > r1 || (l2 > r2)) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[l2]);
        int offset = 0;
        for (int i = 0; i <= r1 - l1; i++) {
            if (inorder[l1 + i] == root.val) {
                offset = i;
            }
        }
        root.left = buildTreeByPreInternal(inorder, l1, l1 + offset - 1, preorder, l2 + 1, l2 + offset);
        root.right = buildTreeByPreInternal(inorder, l1 + offset + 1, r1, preorder, l2 + offset + 1, r2);
        return root;
    }

    /**
     * 654. Maximum Binary Tree
     * https://leetcode-cn.com/problems/maximum-binary-tree/
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeInternal(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTreeInternal(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int max = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTreeInternal(nums, l, max - 1);
        root.right = constructMaximumBinaryTreeInternal(nums, max + 1, r);
        return root;
    }
}
