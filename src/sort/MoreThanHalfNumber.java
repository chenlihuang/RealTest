package sort;

/**
 * 数组中出现次数超过一半的数字.
 */
public class MoreThanHalfNumber {
  /**
   * 利用次数超过一半，则出现次数抵消到最后就是那个数字.
   * @param data 数组
   * @return 数
   */
  public static int moreThanHalfNum2(int[] data) {
    if (data == null || data.length == 0) {
      return 0;
    }
    int count = 1;
    int value = data[0];
    for (int i = 1; i < data.length; i++) {
      if (data[i] == value) {
        count++;
      } else if (data[i] != value && count == 1) {
        value = data[i];
      } else {
        count--;
      }
    }
    return value;
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    int[] data = {1, 2, 3, 2, 2, 2, 5, 4, 2};
    System.out.println(moreThanHalfNum2(data));
    //System.out.println(moreThanHalfNum1(data));
  }

}
