package designpattern;

/**
 * 枚举类常量单例特性.
 */
enum Singleton7 {
  instance;
  private String attribute;

  void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  String getAttribute() {
    return this.attribute;
  }
}
