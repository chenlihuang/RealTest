package sort;

public class Merge {
  public static void mergeSort(int[] data) {
    if (data == null || data.length <= 1)
      return;
    mergeSortCore(data, 0, data.length - 1);
  }

  public static void mergeSortCore(int[] data, int start, int end) {
    System.out.println("sort:" + start + " " + end);
    if (start >= end) {
      return;
    }
    int mid = start + (end - start) / 2;
    mergeSortCore(data, start, mid);
    mergeSortCore(data, mid + 1, end);
    mergeSortMerge(data, start, mid, end);
  }

  public static void mergeSortMerge(int[] data, int start, int mid, int end) {
    System.out.println(start + " " + mid + " " + end);
    if (end == start) {
      return;
    }
    int[] temp = new int[end - start + 1];
    int left = start;
    int right = mid + 1;
    int tempIndex = 0;
    while (left <= mid && right <= end) {
      if (data[left] < data[right]) {
        temp[tempIndex++] = data[left++];
      } else {
        temp[tempIndex++] = data[right++];
      }
    }
    while (left <= mid) {
      temp[tempIndex++] = data[left++];
    }
    while (right <= end) {
      temp[tempIndex++] = data[right++];
    }
    for (int i = 0; i < temp.length; i++) {
      data[start + i] = temp[i];
    }
  }

  public static void main(String[] args) {
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 13, 15, 16,};
    mergeSort(data);
    System.out.print("数组归并排序 ：\t");
    for (int item : data) {
      System.out.print(item);
      System.out.print('\t');
    }
    System.out.println();
  }
}
