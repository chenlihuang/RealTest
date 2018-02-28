package linkedlist;

import structure.ListNode;

/**
 * 链表中间节点.
 */
public class FindMidNode {
  /**
   * 求中间节点.
   * 双指针遍历
   * @param head 头节点
   * @return 中间节点
   */
  public static ListNode<Integer> findMinNode(ListNode<Integer> head) {
    /*if (head == null) {
      return null;
    }*/
    ListNode<Integer> slow = head;
    ListNode<Integer> fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<>(1);
    head.next = new ListNode<>(2);
    head.next.next = new ListNode<>(3);
    head.next.next.next = new ListNode<>(4);
    head.next.next.next.next = new ListNode<>(5);
    head.next.next.next.next.next = new ListNode<>(6);
    System.out.println(findMinNode(head).val);
    ListNode<Integer> head2 = null;
    System.out.println(findMinNode(head2));
  }
}
