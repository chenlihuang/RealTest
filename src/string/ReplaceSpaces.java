package string;

/**
 * 把传入字符数组中的' '换成'&20',且传入数组保证有足够空间容纳修改后的字符.
 */
public class ReplaceSpaces {
  /**
   * 先确定最终数组长度，在从末尾开始遍历，遇到空格则替换.
   *
   * @param data   字符数组
   * @param length 数组长度
   */
  private static void replaceBlank(char[] data, int length) {
    int newLength = length;
    for (int i = 0; i < length; i++) {
      if (data[i] == ' ') {
        newLength += 2;
      }
    }
    for (int indexOfOld = length - 1, indexOfNew = newLength - 1;
         indexOfOld >= 0 && indexOfOld != indexOfNew; indexOfOld--, indexOfNew--) {
      if (data[indexOfOld] == ' ') {
        data[indexOfNew--] = '0';
        data[indexOfNew--] = '2';
        data[indexOfNew] = '%';
      } else {
        data[indexOfNew] = data[indexOfOld];
      }
    }
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    char[] predata = "We are happy.".toCharArray();
    char[] data = new char[17];
//    for (int i = 0; i < predata.length; i++) {
//      data[i] = predata[i];
//    }
    System.arraycopy(predata, 0, data, 0, predata.length);
    System.out.println(data);
    replaceBlank(data, 13);
    System.out.println(data);
  }
}
