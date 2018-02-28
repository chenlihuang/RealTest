package linkedlist;

import structure.ListNode;

/**
 * o(1)时间删除链表的节点.
 */
public class DeleteNodeInList {
  /**
   * 将该节点下一节点覆盖原有内容，同时删除下一节点，等价于删除该节点.
   * @param head 头节点
   * @param node 删除该节点
   * @return 新的头节点
   */
  public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node) {
    if (node == head) { //只有一个节点，即删除头节点
      return head.next;
    } else if (node.next != null) { //删除非尾节点
      node.val = node.next.val;
      node.next = node.next.next;
      return head;
    } else { //删除尾节点 o(n)
      ListNode<Integer> temp = head;
      while (temp.next != node) {
        temp = temp.next;
      }
      temp.next = null;
      return head;
    }
  }

  /**
   * 主程序入口.
   *
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<>(1);
    ListNode<Integer> node2 = new ListNode<>(2);
    ListNode<Integer> node3 = new ListNode<>(3);
    head.next = node2;
    node2.next = node3;
    System.out.println(head);
    head = deleteNode(head, head);
    System.out.println(head);
    head = deleteNode(head, head);
    System.out.println(head);
  }

}
