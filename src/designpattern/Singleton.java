package designpattern;

public class Singleton {
  /**主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    Singleton1 singleton1 = Singleton1.getInstance();
    Singleton2 singleton2 = Singleton2.getInstance();
    Singleton3 singleton3 = Singleton3.getInstance();
  }
}


