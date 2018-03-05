package binarytree;

import java.util.ArrayList;
import java.util.List;
import structure.TreeNode;


/**
 * 二叉树中和为某一值的路径.
 */
public class FindPath {
  /**
   * 用类似于前序遍历的思路解决.
   * @param root 根节点
   * @param exceptedSum 目标和
   */
  public static void findPath(TreeNode<Integer> root, int exceptedSum) {
    if (root == null) {
      return;
    }
    List<Integer> path = new ArrayList<>();
    findPath(root, path, exceptedSum, 0);
  }

  /**
   * 循环调用.
   * @param curNode 将要被访问的节点，还未被加入到path中
   * @param path 路径
   * @param exceptedSum 目标值
   * @param currentSum 当前和
   */
  public static void findPath(TreeNode<Integer> curNode,
                              List<Integer> path, int exceptedSum, int currentSum) {
    path.add(curNode.val);
    currentSum += curNode.val;
    if (curNode.left != null) {
      findPath(curNode.left, path, exceptedSum, currentSum);
    }
    if (curNode.right != null) {
      findPath(curNode.right, path, exceptedSum, currentSum);
    }
    if (curNode.left == null && curNode.right == null && currentSum == exceptedSum) {
      System.out.println(path);
    }
    path.remove(path.size() - 1);
  }

  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    //            10
    //          /   \
    //         5     12
    //       /  \
    //      4    7
    TreeNode<Integer> root = new TreeNode<>(10);
    root.left = new TreeNode<>(5);
    root.right = new TreeNode<>(12);
    //root.right.left = new TreeNode<>(4);
    root.left.left = new TreeNode<>(4);
    root.left.right = new TreeNode<>(7);
    findPath(root,22);
  }
}
