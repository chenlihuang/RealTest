package test.classloading;

public class B extends A {
  private P p1 = new P("B --p1");
  static P p3 = new P("B -- p3");

  public B() {
    System.out.println("B()");
  }

  public P p2 = new P("B -- p2");

  //静态初始化块置后
  static {
    new P("B -- static");
  }

  {
    new P("B{...}");
  }
}
