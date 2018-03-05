package binarytree;

import structure.TreeNode;

/**
 * 二叉树的镜像.
 */
public class MirrorOfBinaryTree {
  /**
   * 镜像二叉树.
   * @param root 二叉树根节点
   */
  public static void mirrorRecursively(TreeNode<Integer> root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      return;
    }
    TreeNode<Integer> temp = root.left;
    root.left = root.right;
    root.right = temp;
    mirrorRecursively(root.left);
    mirrorRecursively(root.right);
  }

  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(8);
    root.left = new TreeNode<>(6);
    root.right = new TreeNode<>(10);
    root.left.left = new TreeNode<>(5);
    root.left.right = new TreeNode<>(7);
    root.right.left = new TreeNode<>(9);
    root.right.right = new TreeNode<>(11);
    System.out.println(root);
    mirrorRecursively(root);
    System.out.println(root);
  }


}
