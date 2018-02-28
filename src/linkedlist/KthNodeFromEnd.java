package linkedlist;

import structure.ListNode;

/**
 * 链表中倒数第k个节点.
 */
public class KthNodeFromEnd {
  /**
   * fast k-1 -> fast n slow n-(k-1).
   * k<=0 链表空 无意义
   * @param head 头节点
   * @param k 倒数第K个
   * @return 节点
   */
  public static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {
    if (head == null || k <= 0) {
      return null;
    }
    ListNode<Integer> slow = head;
    ListNode<Integer> fast = head;
    for (int i = 0; i < k - 1; i++) {
      if (fast.next != null) {
        fast = fast.next;
      } else {
        return null;
      }
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
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
    System.out.println(findKthToTail(head, 1).val);
    System.out.println(findKthToTail(head, 2).val);
    System.out.println(findKthToTail(head, 3).val);
    System.out.println(findKthToTail(head, 4));
  }

}
