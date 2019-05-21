package course.charper3;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 二叉树
 * @author cm
 * @param <E>
 */
public class BinaryTree<E> {

	/**
	 * 生成二叉树
	 * @param inputList
	 * @return
	 */
	public TreeNode<E> createBinaryTree(LinkedList<E> inputList){
		TreeNode<E> node = null;
		if(inputList == null || inputList.size() == 0) {
			return null;
		}
		E data = inputList.removeFirst();
		if(data != null) {
			node = new TreeNode<E>(data);
			node.setLeftChild(createBinaryTree(inputList));
			node.setRightChild(createBinaryTree(inputList));
		}
		return node;
	}
	
	/**
	 * 二叉树前序遍历
	 * 顺序：根节点，左子树，右子树
	 * @param node
	 */
	public void preOrderTraversal(TreeNode<E> node) {
		if(node == null) {
			return;
		}
		System.out.println(node.getData());
		preOrderTraversal(node.getLeftChild());
		preOrderTraversal(node.getRightChild());
	}
	
	/**
	 * 二叉树中序遍历
	 * 顺序：左子树，根节点，右子树
	 * @param node
	 */
	public void middleOrderTraversal(TreeNode<E> node) {
		if(node == null) {
			return;
		}
		middleOrderTraversal(node.getLeftChild());
		System.out.println(node.getData());
		middleOrderTraversal(node.getRightChild());
	}
	
	/**
	 * 二叉树后序遍历
	 * 顺序：左子树，右子树，根节点
	 * @param node
	 */
	public void postOrderTraversal(TreeNode<E> node) {
		if(node == null) {
			return;
		}
		postOrderTraversal(node.getLeftChild());
		postOrderTraversal(node.getRightChild());
		System.out.println(node.getData());
	}
	
	public static void main(String[] args) {
//		LinkedList<Integer> inputList = new LinkedList<Integer>();
//		inputList.add(3);
//		inputList.add(2);
//		inputList.add(9);
//		inputList.add(null);
//		inputList.add(null);
//		inputList.add(10);
//		inputList.add(null);
//		inputList.add(null);
//		inputList.add(8);
//		inputList.add(null);
//		inputList.add(4);
//
//		BinaryTree<Integer> tree = new BinaryTree<Integer>();
//		TreeNode<Integer> node = tree.createBinaryTree(inputList);
//		System.out.println("前序遍历：");
//		tree.preOrderTraversal(node);
//		System.out.println("中序遍历：");
//		tree.middleOrderTraversal(node);
//		System.out.println("后序遍历：");
//		tree.postOrderTraversal(node);
		
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		map.put("abc", 1);
		map.put("def", 2);
		System.out.println(map);
	}
	
}
