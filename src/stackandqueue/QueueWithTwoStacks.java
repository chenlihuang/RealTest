package stackandqueue;

public class QueueWithTwoStacks {
  public static void main(String[] args) {
    MyQueue<Integer> myQueue = new MyQueue<>();
    System.out.println(myQueue.poll());
    myQueue.offer(1);
    myQueue.offer(2);
    myQueue.offer(3);
    System.out.println(myQueue.poll());
    System.out.println(myQueue.poll());
    myQueue.offer(4);
    System.out.println(myQueue.poll());
    System.out.println(myQueue.poll());
    System.out.println(myQueue.poll());

    MyStack<Integer> myStack = new MyStack<>();
    System.out.println(myStack.pop());
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    myStack.push(4);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
  }
}
