package test.classloading;

public class ClassLoaderTest {
  public static void main(String[] args) {
    new B();
    new A.C();
  }
}
