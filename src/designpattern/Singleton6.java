package designpattern;

/**
 * 静态内部类实现，多线程安全.
 * final保证对象唯一性
 * 内部类在需要时实现初始化
 */
public class Singleton6 {
  private Singleton6(){
  }

  public static Singleton6 getInstance() {
    return Singleton6Holder.instance;
  }

  private static class Singleton6Holder {
    private static final Singleton6 instance = new Singleton6();
  }
}
