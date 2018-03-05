package binarytree;

/**
 * 二叉搜索树的后序遍历.
 */
public class SequenceOfBST {
  /**
   * 判断序列是否符合二叉搜索树的后序遍历.
   * @param data 序列
   * @return 是否
   */
  public static boolean verifySquenceOfBst(int[] data) {
    //空树
    if (data == null || data.length == 0) {
      return false;
    }
    return verifySquenceOfBst(data, 0, data.length - 1);
  }

  /**
   * 判断序列是否符合二叉搜索树的后序遍历.
   * @param data 序列
   * @param start 开始
   * @param end 结束
   * @return 是否符合规则
   */
  public static boolean verifySquenceOfBst(int[] data, int start, int end) {
    //数组长度为2，一定能够组成BST
    if (end - start <= 1) {
      return true;
    }
    int root = data[end];
    int rightStart = 0;
    for (int i = 0; i < end; i++) {
      if (data[i] > root) {
        rightStart = i;
        break;
      }
    }
    for (int i = rightStart; i < end; i++) {
      if (data[i] < root) {
        return false;
      }
    }
    return verifySquenceOfBst(data, start, rightStart - 1) && verifySquenceOfBst(data, rightStart, end - 1);
  }

  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    //            8
    //          /   \
    //         6     10
    //       /  \   / \
    //      5    7 9   11
    int[] data = {5, 7, 6, 9, 4, 10, 8};
    int[] data1 = {5, 7, 6, 9, 11, 10, 8};
    System.out.println(verifySquenceOfBst(data));
    System.out.println(verifySquenceOfBst(data1));
  }

}
