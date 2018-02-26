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
  }
}
