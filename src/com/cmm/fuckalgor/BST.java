package com.cmm.fuckalgor;

/**
 * @author cmm
 * @date 2020/6/14 5:07 PM
 * @desc 二叉搜索树(平衡二叉树) :一个二叉树中，任意节点的值要大于等于左子树所有节点的值，且要小于等于右边子树的所有节点的值。
 */
public class BST {


    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树算法的设计的总路线
     *
     * @param root
     */
    void traverse(TreeNode root) {
        // root 需要做什么？在这做。
        // 其他的不用 root 操心，抛给框架
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 二叉树所有的节点中的值加一
     *
     * @param root
     */
    void plusOne(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val += 1;
        plusOne(root.left);
        plusOne(root.right);
    }

    /**
     * 判断两棵二叉树是否完全相同
     *
     * @param root1
     * @param root2
     * @return
     */
    boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    /**
     * 使用辅助函数，增加函数参数列表
     *
     * @param root
     * @return
     */
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 判定是否是二叉平衡树
     * root 需要做的不只是和左右子节点比较，而是要整个左子树和右子树所有节点比较
     *
     * @param root
     * @param min
     * @param max
     * @return
     */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return isInBST(root.left, target) || isInBST(root.right, target);
    }

    boolean isInBST2(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return isInBST2(root.right, target);
        }
        return isInBST2(root.left, target);
    }

    TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;

    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            // 左节点
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


}
