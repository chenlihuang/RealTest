package designpattern;

/**
 * 线程安全，第一次获取实例时分配内存,synchronized内部锁.
 */
class Singleton3 {
  private static Singleton3 instance = null;

  private Singleton3() {
  }

  public static synchronized Singleton3 getInstance() {
    if (instance == null) {
      instance = new Singleton3();
    }
    return instance;
  }
}