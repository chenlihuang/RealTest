package string;

/**
 * 打印从1到最大的n位数,在字符串上模拟加法.
 */
public class Print1ToMaxOfNDigits {
  public static void print1ToMaxOfNDigits(int num) {
    if (num <= 0) {
      return;
    }
    StringBuilder number = new StringBuilder(num);
    for (int i = 0; i < num; i++) { //将字符串各位初始化为0
      number.append('0');
    }
    while (increment(number)) {
      printNumber(number);
    }
  }

  /**
   * 加一.
   *
   * @param str 字符串
   * @return 字符串实现加一后
   */
  public static boolean increment(StringBuilder str) {
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) < '9' && str.charAt(i) >= '0') {
        str.setCharAt(i, (char) (str.charAt(i) + 1));
        return true;
      } else if (str.charAt(i) == '9') {
        str.setCharAt(i, '0');
      } else {
        return false;
      }
    }
    return false;
  }

  /**
   * 输出字符串代表的数字.
   * @param number 字符串
   */
  public static void printNumber(StringBuilder number) {
    boolean flag = false; //判断哪一位为开始位，比如输入为4，0012，需要判断输出为12，不是0012
    for (int i = 0; i < number.length(); i++) {
      if (flag) {
        System.out.print(number.charAt(i));
      } else {
        if (number.charAt(i) != '0') {
          flag = true;
          System.out.print(number.charAt(i));
        }
      }
    }
    System.out.println();
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    print1ToMaxOfNDigits(2);
  }
}
