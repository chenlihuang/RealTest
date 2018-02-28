package linkedlist;

import structure.ListNode;

/**
 * 单向链表是否存在环形链表。
 */
public class CircleInLinkList {
  /**
   * 判断单向链表是否存在环..
   * 双指针遍历
   *
   * @param head 头节点
   * @return 是否存在环
   */
  public static boolean findCircle(ListNode<Integer> head) {
    /*if (head == null) {
      return null;
    }*/
    ListNode<Integer> slow = head;
    ListNode<Integer> fast = head.next;
    while (fast != null && fast.next != null) {
      if (slow == fast) {
        return true;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    return false;
  }

  /**
   * 判断单向链表是否存在环,存在返回环的入口节点..
   * 双指针遍历
   *
   * @param head 头节点
   * @return 是否存在环
   */
  public static ListNode<Integer> findCircleNode(ListNode<Integer> head) {
    /*if (head == null) {
      return null;
    }*/
    ListNode<Integer> slow = head;
    ListNode<Integer> fast = head.next;
    if (fast == null || fast.next == null) {
      return null;
    }
    while (fast != null && fast.next != null) {
      if (slow == fast) {
        return null;
      }
      fast = fast.next.next;
      slow = slow.next;
    }

    fast = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }

  /**
   * 判断单向链表是否存在环.
   * 双指针遍历
   *
   * @param head 头节点
   * @return 环的长度
   */
  public static int findCircleLength(ListNode<Integer> head) {
    /*if (head == null) {
      return null;
    }*/
    ListNode<Integer> start = findCircleNode(head);
    if(start == null) {
      return 0;
    }
    ListNode<Integer> fast = start.next;
    int length = 1;
    while (start != fast) {
      fast = fast.next;
      length++;
    }
    return length;


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
    if (findCircle(head)) {
      System.out.println("存在");
    } else {
      System.out.println("不存在");
    }
  }
}
