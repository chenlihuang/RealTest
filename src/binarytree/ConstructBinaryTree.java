package binarytree;

import java.util.List;
import structure.TreeNode;


/**
 * 重建二叉树.
 * 前序+中序，后续+中序可以完成重建，而前序+后序无法完成
 */
public class ConstructBinaryTree {
  /**
   * 重建函数.
   * @param preorder 前序
   * @param inorder 中序
   * @return 节点
   */
  public static TreeNode construct(int[] preorder,int[] inorder) {
    if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
      return null;
    }
    return constructCore(preorder,0,inorder,0,preorder.length);
  }

  /**
   * 重建循环函数.
   * @param preorder 前序
   * @param preOrderStart 序号
   * @param inorder 中序
   * @param inOrderStart 序号
   * @param length 长度
   * @return 节点
   */
  public static TreeNode constructCore(int[] preorder,int preOrderStart,
                                       int[] inorder,int inOrderStart,int length) {
    if (length == 0) {
      return null;
    }
    int inOrderIndex = -1;
    for (int i = inOrderStart;i < inOrderStart + length;i++) {
      if (inorder[i] == preorder[preOrderStart]) {
        inOrderIndex = i;
        break;
      }
    }
    int leftLength = inOrderIndex - inOrderStart;
    TreeNode node = new TreeNode(preorder[preOrderStart]);
    node.left = constructCore(preorder,preOrderStart + 1,inorder,inOrderStart,leftLength);
    node.right = constructCore(preorder,preOrderStart + leftLength + 1,inorder,
            inOrderIndex + 1,length - leftLength - 1);
    return node;
  }


  /**
   * 主程序入口.
   * @param args 命令行输入传入
   */
  public static void main(String[] args) {
    //            1
    //          /   \
    //         2     3
    //        / \
    //       4   5
    //pre->12453  in->42513   post->45231
    int[] pre = {1,2,4,5,3};
    int[] in = {4,2,5,1,3};
    TreeNode root = construct(pre,in);
    //对重建后的树,进行前中后序遍历，验证是否重建正确
    //调用的重建函数见：http://www.jianshu.com/p/362d4ff42ab2
    List<Integer> preorder = TraversalOfBinaryTree.preorderIteratively(root);
    List<Integer> inorder = TraversalOfBinaryTree.inorderIteratively(root);
    List<Integer> postorder = TraversalOfBinaryTree.postorderIteratively(root);
    System.out.println(preorder);
    System.out.println(inorder);
    System.out.println(postorder);

  }
}
