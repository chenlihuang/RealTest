package sort;

public class Heap {
  public static void sort(int[] data) {
    //1.构建大顶堆
    for (int i = data.length / 2 - 1; i >= 0; i--) {
      //从第一个非叶子结点从下至上，从右至左调整结构
      adjustHeap(data, i, data.length - 1);
    }
    //2.调整堆结构+交换堆顶元素与末尾元素
    for (int j = data.length - 1; j >= 0; j--) {
      exch(data, 0, j);//将堆顶元素与末尾元素进行交换
      adjustHeap(data, 0, j - 1);//重新对堆进行调整
      System.out.println(data[j]);
    }

  }


  private static void adjustHeap(int[] data, int i, int end) {
    int left = 2 * i;
    int right = 2 * i + 1;
    int max = i;
    if (left <= end && data[left] > data[max]) {
      max = left;
    }
    if (right <= end && data[right] > data[max]) {
      max = right;
    }
    if (max != i) {
//      int temp = data[max];
//      data[max] = data[i];
//      data[i] = temp;
      exch(data,i,max);
      adjustHeap(data, max, end);
    }
  }


  private static void exch(int[] data, int i, int j) {
    int swap = data[i];
    data[i] = data[j];
    data[j] = swap;
  }

  public static void main(String[] args) {
    int[] data = {1, 2, 5, 4, 3, 6, 7, 8, 9, 10, 11, 12, 14, 13, 15, 16,};
    sort(data);
    System.out.print("数组堆排序 ：\t");
    for (int item : data) {
      System.out.print(item);
      System.out.print('\t');
    }
    System.out.println();
  }


}
