package sort;

/**
 * 调整数组顺序使奇数位于偶数前面.
 */
public class ReorderArray {
  /**
   * 调整数组顺序.
   * @param data 数组.
   */
  public static void reorder(int[] data) {
    if (data == null || data.length < 2) {
      return;
    }
    int left = 0;
    int right = data.length - 1;
    while (left < right) {
      while (left < right && !isEven(data[left])) {
        left++;
      }
      while (left < right && isEven(data[right])) {
        right--;
      }
      if (left < right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
      }
    }
  }

  /**
   * 判断是否为偶数.
   * 可以更改条件，诸如非负，可以被三整除等
   * @param n 值
   * @return 判断
   */
  public static boolean isEven(int n) {
    return (n & 1) == 0;
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    int[] data = {1, 2, 3, 4, 5, 7, 7};
    reorder(data);
    /*    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i]);
      System.out.print('\t');
     } */
    for (int i:data) {
      System.out.print(i);
      System.out.print('\t');
    }
    System.out.println();
  }

}
