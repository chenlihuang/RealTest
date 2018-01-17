package test.classloading;

public class A {
  //静态初始化块提前
  static {
    new P("A--static");
  }

  private P p1 = new P("A--p1");

  //非静态初始化块提前
  {
    new P("A{...}");
  }

  static P p3 = new P("A--p3");

  public A() {
    System.out.println("A()");
  }

  private P p2 = new P("A--p2");

  public static class C {
    private P p1 = new P("C--p1");
    static P p3 = new P("C--p3");

    public C() {
      System.out.println("C()");
    }

    private P p2 = new P("C--p2");

    static {
      new P("C--static");
    }

    {
      new P("C{...}");
    }
  }
}
