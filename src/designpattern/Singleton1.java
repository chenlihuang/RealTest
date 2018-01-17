package designpattern;

/**
 * 线程安全；在类初始化执行到静态属性时就分配了资源，有资源浪费问题.
 */
class Singleton1 {
  private static final Singleton1 instance = new Singleton1();

  private Singleton1() {
  }

  public static Singleton1 getInstance() {
    return instance;
  }
}