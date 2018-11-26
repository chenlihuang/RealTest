package sort;

public class Quick {
  public static void quickSort(int[] data) {
    if (data == null || data.length <= 1) {
      return;
    }
    quickSortCore(data, 0, data.length - 1);
  }

  public static void quickSortCore(int[] data, int start, int end) {
    if (end - start <= 0) {
      return;
    }
    int index = partition(data, start, end);
    quickSortCore(data, start, index - 1);
    quickSortCore(data, index + 1, end);
  }

  public static int partition(int[] data, int start, int end) {
    int left = start;
    int right = end + 1;
    while (true) {
      while (data[++left] < data[start]) {
        if (left == end) {
          break;
        }
      }
      while (data[--right] > data[start]) {
        if (right == start) {
          break;
        }
      }
      if (left >= right) {
        break;
      }
      exch(data, left, right);
    }
    exch(data, start, right);
    return right;
  }

  private static void exch(int[] data, int i, int j) {
    int swap = data[i];
    data[i] = data[j];
    data[j] = swap;
  }

  public static void main(String[] args) {
    int[] data = {5, 4, 3, 1, 2};
    quickSort(data);
    System.out.print("数组快速排序 ：\t");
    for (int item : data) {
      System.out.print(item);
      System.out.print('\t');
    }
    System.out.println();

  }
}
