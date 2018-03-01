package linkedlist;

import structure.ListNode;

/**
 * 反转链表.
 */
public class ReverseList {
  /**
   * 反转链表.
   *
   * @param head 头节点
   * @return 反转后的头节点
   */
  public static ListNode<Integer> reverseList(ListNode<Integer> head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode<Integer> pre = null;
    ListNode<Integer> cur = head;
    ListNode<Integer> post = head.next;
    while (true) {
      cur.next = pre;
      pre = cur;
      cur = post;
      if (post != null) {
        post = post.next;
      } else {
        return pre;
      }
    }
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
    System.out.println(head);
    head = reverseList(head);
    System.out.println(head);
  }
}
