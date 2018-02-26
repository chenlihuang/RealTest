package linkedlist;

/**
 * 斐波那契数列.
 */
public class Fibonacci {
  // 依据原始概念的递归解法，时间复杂度o(n^2)
  public static int fibonacci1(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibonacci1(n - 1) + fibonacci1(n - 2);
  }

  // 当前状态只与前两个状态有关。存储前两个值，计算后一个，迭代进行。时间复杂度o(n)
  public static int fibonacci2(int n) {
    if (n <= 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int temp1 = 0;
    int temp2 = 1;
    int result = temp1 + temp2;
    int i = 3;
    while (i <= n) {
      //也可用一个队列来完成下面三行的操作
      temp1 = temp2;
      temp2 = result;
      result = temp1 + temp2;
      i++;
    }
    return result;
  }


  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    System.out.println(fibonacci1(13));
    System.out.println(fibonacci2(13));
  }
}
