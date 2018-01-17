package test.enumtest;

import java.util.Scanner;

public class EnumTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
    String input = in.next().toUpperCase();
    Size size = Enum.valueOf(Size.class, input);
    System.out.println("size=" + size);
    System.out.println("abbreviation=" + size.getAbbreviation());
    if (size == Size.EXTRA_LARGE) {
      System.out.println("EXTRA_LARGE");
    } else if (size == Size.LARGE) {
      System.out.println("LARGE.");
    } else if (size == Size.SMALL) {
      System.out.println("SMALL");
    } else if (size == Size.MEDIUM) {
      System.out.println("MEDIUM");
    }
  }
}
