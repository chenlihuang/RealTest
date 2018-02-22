package binarytree;

import java.util.*;

import structure.TreeNode;

/**
 * 二叉树的遍历.
 */
public class TraversalOfBinaryTree {
  /**
   * 前序遍历递归版.
   * @param node 根结点
   * @return 遍历的输出
   */
  public static List<Integer> preorderRecursively(TreeNode<Integer> node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) {
      return list;
    }
    list.add(node.val);
    list.addAll(preorderRecursively(node.left));
    list.addAll(preorderRecursively(node.right));
    return list;
  }

  /**
   * 前序遍历非递归版.
   * @param node 根结点
   * @return 遍历的输出
   */
  public static List<Integer> preorderIteratively(TreeNode<Integer> node) {
    //stack栈顶元素永远为cur的父节点
    Stack<TreeNode<Integer>> stack = new Stack<>();
    TreeNode<Integer> cur = node;
    List<Integer> list = new LinkedList<>();
    if (node == null) {
      return list;
    }
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        list.add(cur.val);
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.pop().right;
      }
    }
    return list;
  }

  /**
   * 中序遍历递归版.
   * @param node 根结点
   * @return 遍历的输出
   */
  public static List<Integer> inorderRecursively(TreeNode<Integer> node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) {
      return list;
    }
    list.addAll(inorderRecursively(node.left));
    list.add(node.val);
    list.addAll(inorderRecursively(node.right));
    return list;
  }

  /**
   * 中序遍历非递归版.
   * @param node 根结点
   * @return 遍历的输出
   */
  public static List<Integer> inorderIteratively(TreeNode<Integer> node) {
    //stack栈顶元素永远为cur的父节点
    Stack<TreeNode<Integer>> stack = new Stack<>();
    TreeNode<Integer> cur = node;
    List<Integer> list = new LinkedList<>();
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        list.add(stack.peek().val);
        cur = stack.pop().right;
      }
    }
    return list;
  }

  /**
   * 后序遍历递归版.
   * @param node 根结点
   * @return 遍历的输出
   */
  public static List<Integer> postorderRecursively(TreeNode<Integer> node) {
    List<Integer> list = new ArrayList<>();
    if (node == null) {
      return list;
    }
    list.addAll(postorderRecursively(node.left));
    list.addAll(postorderRecursively(node.right));
    list.add(node.val);
    return list;
  }


  /**
   * 后序遍历非递归版.
   * @param node 根结点
   * @return 遍历的输出
   */
  public static List<Integer> postorderIteratively(TreeNode<Integer> node) {
    //stack栈顶元素永远为cur的父节点
    //prevVisted用于区分是从左子树还是右子树返回的
    Stack<TreeNode<Integer>> stack = new Stack<>();
    TreeNode<Integer> cur = node;
    TreeNode<Integer> prevVisted = null;
    List<Integer> list = new LinkedList<>();
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        cur = cur.left;
      } else {
        cur = stack.peek().right;
        if (cur != null && cur != prevVisted) {
          stack.push(cur);
          cur = cur.left;
        } else {
          prevVisted = stack.pop();
          list.add(prevVisted.val);
          cur = null;
        }
      }
    }
    return list;
  }

  /**
   * 层序遍历.
   * @param node 根结点
   * @return 遍历的输出
   */
  public static List<Integer> levelorder(TreeNode<Integer> node) {
    Queue<TreeNode<Integer>> queue = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    TreeNode<Integer> temp = null;
    if (node == null) {
      return list;
    }
    queue.add(node);
    while (!queue.isEmpty()) {
      temp = queue.poll();
      list.add(temp.val);
      if (temp.left != null) {
        queue.offer(temp.left);
      }
      if (temp.right != null) {
        queue.offer(temp.right);
      }
    }
    return list;
  }


  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    //            1
    //              \
    //               2
    //              /
    //             3
    //pre->123  in->132   post->321  level->123
    TreeNode<Integer> root = new TreeNode<>(1);
    root.right = new TreeNode<>(2);
    root.right.left = new TreeNode<>(3);

    List<Integer> listPreorderRecursively = preorderRecursively(root);
    System.out.print("preorderRecursively: " + '\t');
    System.out.println(listPreorderRecursively.toString());

    List<Integer> listPreorderIteratively = preorderIteratively(root);
    System.out.print("preorderIteratively: " + '\t');
    System.out.println(listPreorderIteratively.toString());

    List<Integer> listInorderRecursively = inorderRecursively(root);
    System.out.print("inorderRecursively: " + '\t');
    System.out.println(listInorderRecursively.toString());

    List<Integer> listInorderIteratively = inorderIteratively(root);
    System.out.print("inorderIteratively: " + '\t');
    System.out.println(listInorderIteratively.toString());

    List<Integer> listPostorderRecursively = postorderRecursively(root);
    System.out.print("postorderRecursively: " + '\t');
    System.out.println(listPostorderRecursively.toString());

    List<Integer> listPostorderIteratively = postorderIteratively(root);
    System.out.print("postorderIteratively: " + '\t');
    System.out.println(listPostorderIteratively.toString());

    List<Integer> listLevelorder = levelorder(root);
    System.out.print("levelorder: " + '\t');
    System.out.println(listLevelorder.toString());


  }
}
