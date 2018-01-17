package designpattern;

/**
 * 线程安全，第一次获取实例时分配内存,synchronized内部锁.
 */
class Singleton4 {
  private static Singleton4 instance = null;

  private Singleton4() {
  }

  public static Singleton4 getInstance() {
    synchronized (Singleton4.class) {
      if (instance == null) {
        instance = new Singleton4();
      }
      return instance;
    }
  }
}