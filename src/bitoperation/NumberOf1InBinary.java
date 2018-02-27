package bitoperation;

/**
 * 二进制中的1的个数.
 */
public class NumberOf1InBinary {
  /**
   * 判断数字二进制最低位是否为一，右移直到0.无符号右移
   *
   * @param n 整数
   * @return 返回二进制1的个数
   */
  public static int numberOfOne1(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) != 0) {
        count++;
      }
      n >>>= 1;
    }
    return count;
  }

  /**
   * 借助标识,初始为1，标识不断左移，从最低位判断是否为1.
   *
   * @param n 整数
   * @return 返回二进制1的个数
   */
  public static int numberOfOne2(int n) {
    int count = 0;
    int flag = 1;
    while (flag != 0) {
      if ((n & flag) != 0) {
        count++;
      }
      flag <<= 1;
    }
    return count;
  }

  /**
   * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把原整数的二进制表示形式的最右边的1变成0.
   *
   * @param n 整数
   * @return 返回二进制1的个数
   */
  public static int numberOfOne3(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n - 1);
      count++;
    }
    return count;
  }


  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    System.out.println(numberOfOne1(3));
    System.out.println(numberOfOne1(-3));
    System.out.println(numberOfOne2(3));
    System.out.println(numberOfOne2(-3));
    System.out.println(numberOfOne3(3));
    System.out.println(numberOfOne3(-3));
  }
}
