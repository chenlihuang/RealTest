package designpattern;

/**
 * 值的整数次方.
 */
public class Power {
  static boolean invalidInput = false;

  /**
   * 计算幂.
   *
   * @param base     底数
   * @param exponent 指数
   * @return 幂
   */
  public static double power(double base, int exponent) {
    if (exponent == 0) {  //0的0次方在数学上没有意义，为了方便也返回1，也可特殊处理
      return 1;
    }
    if (exponent < 0) {
      if (equal(base, 0)) { //指数小于0，底数等于0
        invalidInput = true;  //通过全局变量报错
        return 0;
      } else {  //指数小于0，底数不等于0
        return 1.0 / powerWithPositiveExponent(base, -1 * exponent);
      }
    } else {  //指数大于0
      return powerWithPositiveExponent(base, exponent);
    }
  }

  /**
   * 计算底数为正数幂.
   *
   * @param base     底数
   * @param exponent 指数
   * @return 幂
   */
  public static double powerWithPositiveExponent(double base, int exponent) {
    double result = 1.0;
    if (exponent == 0) {
      return 1;
    } else {
      for (int i = 1; i <= exponent; i++) {
        result *= base;
      }
      return result;
    }
//    } else if ((exponent & 1) == 0) { //可以被二整除
//      double temp = powerWithPositiveExponent(base, exponent >> 1);
//      return temp * temp;
//    } else {
//      double temp = powerWithPositiveExponent(base, exponent >> 1);
//      return base * temp * temp;
//    }
  }

  /**
   * 小数相等判断.
   *
   * @param x x
   * @param y y
   * @return x, y是否相等
   */
  public static boolean equal(double x, double y) {
    return -0.00001 < x - y && x - y < 0.00001;
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    System.out.println("2^3=" + power(2, 3) + "\t是否报错:" + invalidInput);
    System.out.println("2^-3=" + power(2, -3) + "\t是否报错:" + invalidInput);
    System.out.println("0^3=" + power(0, 3) + "\t是否报错:" + invalidInput);
    System.out.println("0^-3=" + power(0, -3) + "\t是否报错:" + invalidInput);
  }

}
