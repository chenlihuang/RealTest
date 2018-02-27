package string;

/**
 * 大数加法.
 */
public class Add {
  public static String add(String n1, String n2) {
    StringBuffer result = new StringBuffer();
    n1 = new StringBuffer(n1).reverse().toString();
    n2 = new StringBuffer(n2).reverse().toString();

    int len1 = n1.length();
    int len2 = n2.length();
    int maxLen = len1 > len2 ? len1 : len2;
    boolean overFlow = false; //是否越界
    int takeOver = 0; //溢出数量

    //2.把两个字符串补齐，即短字符串的高位用0补齐
    if (len1 < len2) {
      for (int i = len1; i < len2; i++) {
        n1 = new StringBuffer(n1).append("0").toString();
      }
    } else if (len1 > len2) {
      for (int i = len2; i < len1; i++) {
        n1 = new StringBuffer(n1).append("0").toString();
      }
    }

    //3.把两个正整数相加，一位一位的加并加上进位
    for (int i = 0; i < maxLen; i++) {
      int sum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + takeOver;

      if (sum >= 10) {
        if (i == (maxLen - 1)) {
          overFlow = true;
        }
        takeOver = 1;
        result.append(sum - 10);
      } else {
        takeOver = 0;
        result.append(sum);
      }
    }

    //如果溢出的话表示位增加了
    if (overFlow) {
      result.append(takeOver);
    }
    return result.reverse().toString();
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    String str = add("915", "225");
    System.out.println(str);
  }
}
