package designpattern;

/**
 * 非线程安全，第一次获取实例时分配内存.
 */
class Singleton2 {
  private static Singleton2 instance = null;

  private Singleton2() {
  }

  public static Singleton2 getInstance() {
    if (instance == null) {
      instance = new Singleton2();
    }
    return instance;
  }
}