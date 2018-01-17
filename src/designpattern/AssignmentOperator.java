package designpattern;

/**
 * 赋值运算符函数.
 * java不支持运算符重载，赋值操作以assign函数代替，部分实现功能，连续赋值存在bug，s3->s2->s1，s2不被赋值
 */
public class AssignmentOperator {
  public static class MyString {
    private String data;

    /**
     * 构造函数.
     *
     * @param data 待赋值字符串
     */
    private MyString(String data) {
      this.data = data;
    }

    private MyString assign(final MyString another) {
      if (this == another || this.data.equals(another.data)) {
        return this;
      } else {
        this.data = another.data;
        return this;
      }
    }

    @Override
    public String toString() {
      return "MyString{" + "data='" + data + '\'' + '}';
    }
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    MyString s1 = new MyString("a");
    MyString s2 = new MyString("b");
    MyString s3 = new MyString("c");
    System.out.println(s1.assign(s2).assign(s3));
    System.out.println("s1:" + s1);
    System.out.println("s2:" + s2);
    System.out.println("s3:" + s3);
  }
}
