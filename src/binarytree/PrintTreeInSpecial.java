package binarytree;


import java.util.Stack;
import structure.TreeNode;


public class PrintTreeInSpecial {

  /**
   * 之字形打印二叉树.
   * 通过两个栈实现
   * stack1 奇数行
   * stack2 偶数行
   *
   * @param root 根节点
   */
  public static void printTreeInSpeical(TreeNode<Integer> root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode<Integer>> stack1 = new Stack<>();
    Stack<TreeNode<Integer>> stack2 = new Stack<>();
    TreeNode<Integer> temp;
    stack1.push(root);
    while (!stack1.isEmpty() || !stack2.isEmpty()) {
      if (!stack1.isEmpty()) {
        while (!stack1.isEmpty()) {
          temp = stack1.pop();
          System.out.print(temp.val);
          System.out.print('\t');
          if (temp.left != null) {
            stack2.push(temp.left);
          }
          if (temp.right != null) {
            stack2.push(temp.right);
          }
        }
      } else {
        while (!stack2.isEmpty()) {
          temp = stack2.pop();
          System.out.print(temp.val);
          System.out.print('\t');
          if (temp.right != null) {
            stack1.push(temp.right);
          }
          if (temp.left != null) {
            stack1.push(temp.left);
          }
        }
      }
      System.out.println();
    }
  }

  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    //            1
    //          /   \
    //         2     3
    //       /  \   / \
    //      4    5 6   7
    TreeNode<Integer> root = new TreeNode<>(1);
    root.left = new TreeNode<>(2);
    root.right = new TreeNode<>(3);
    root.left.left = new TreeNode<>(4);
    root.left.right = new TreeNode<>(5);
    root.right.left = new TreeNode<>(6);
    root.right.right = new TreeNode<>(7);
    printTreeInSpeical(root);
  }

}
