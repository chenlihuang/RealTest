package stackandqueue;

public class StackWithMintest {
  public static void main(String[] args) {
    StackWithMin<Integer> stack = new StackWithMin<>();
    stack.push(3);
    stack.push(4);
    stack.push(2);
    stack.push(1);
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
  }
}


