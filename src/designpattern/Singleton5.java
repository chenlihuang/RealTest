package designpattern;

/**
 * 线程安全，双重检查锁，null和synchronized.
 * 第一层检查为了弥补单synchronized的多次同步，当实例存在时不再同步
 * 第二层检查是为了当多线程突破第一层检查时，保证锁住一个线程，当同步锁放开后，第二个线程会被第二个非空判断所检查到，不
 * 会再创建对象.
 * 对象声明volatile，使得创建对象有原子性，不会被其他线程打断，避免在第一层非空判断时，获取一个没有new的对象.
 *
 */
class Singleton5 {
  private static volatile Singleton5 instance = null;

  private Singleton5() {
  }

  public static Singleton5 getInstance() {
    if (instance == null) {
      synchronized (Singleton5.class) {
        if (instance == null) {
          instance = new Singleton5();
        }
      }
    }
    return instance;
  }
}