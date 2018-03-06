package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/**
 * 字符串的排列.
 */
public class StringPermutation {
  /**
   * 排列.
   *
   * @param strs 字符串
   * @return 排列列表
   */
  public static List<char[]> permutation(char[] strs) {
    if (strs == null || strs.length == 0) {
      return null;
    }
    List<char[]> ret = new LinkedList<>();
    permutationCore(strs, ret, 0);
    return ret;
  }

  /**
   * 迭代，第一个字符和之后的字符交换.
   *
   * @param strs  字符串
   * @param ret   排列列表
   * @param bound 第几个字符
   */
  public static void permutationCore(char[] strs, List<char[]> ret, int bound) {
    if (bound == strs.length) {
      ret.add(Arrays.copyOf(strs, strs.length));
    }
    Set<Character> set = new HashSet<>();
    for (int i = bound; i < strs.length; i++) {
      if (set.add(strs[i])) { //重复字符不交换
        swap(strs, bound, i);
        permutationCore(strs, ret, bound + 1);
        swap(strs, bound, i);
      }
    }
  }

  /**
   * 交换数组x,y位置数据.
   *
   * @param strs 数组
   * @param x    位置x
   * @param y    位置y
   */
  public static void swap(char[] strs, int x, int y) {
    char temp = strs[x];
    strs[x] = strs[y];
    strs[y] = temp;
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    char[] strs = {'a', 'b', 'c'};
    List<char[]> ret = permutation(strs);
    for (char[] item : ret) {
      for (char i : item) {
        System.out.print(i);
      }
      System.out.println();
    }
    System.out.println();
    char[] strs2 = {'a', 'a', 'b', 'b'};
    List<char[]> ret2 = permutation(strs2);
    for (char[] item : ret2) {
      for (char i : item) {
        System.out.print(i);
      }
      System.out.println();
    }
  }
}
