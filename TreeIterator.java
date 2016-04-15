package HW6;

import java.util.LinkedList;

public class TreeIterator<T> implements java.util.Iterator<T> {

	private BinaryTreeBasis<T> binTree;
	private TreeNode<T> currentNode;
	private LinkedList <TreeNode<T>> queue; 
	
	/**
	 * Implementation of an iterator, need to create an instance object of TreeIterator 
	 * to then iterate through objects
	 * @param bTree
	 */
	public TreeIterator(BinaryTreeBasis<T> bTree){
		binTree = bTree;
		currentNode = null;
		//empty queue indicates no traversal type currently
		//selected or end of current traversal has been reached
		queue = new LinkedList<TreeNode<T>>();
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !queue.isEmpty();
	}

	@Override
	public T next() throws java.util.NoSuchElementException{
		// TODO Auto-generated method stub
		currentNode = queue.remove();
		return currentNode.getItem();
	}

	@Override
	public void remove() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void setPreorder(){
		queue.clear();
		preorder(binTree.root);
	}
	public void setInorder(){
		queue.clear();
		inorder(binTree.root);
	}
	
	public void setPostorder(){
		queue.clear();
		postorder(binTree.root);
	}
	
	private void preorder(TreeNode<T> treeNode) {
		// TODO Auto-generated method stub
		if(treeNode!=null){
			queue.add(treeNode);
			preorder(treeNode.getLeftChild());
			preorder(treeNode.getRightChild());
		}
		
	}
	private void inorder(TreeNode<T> treeNode) {
		// TODO Auto-generated method stub
		if(treeNode!=null){
			inorder(treeNode.getLeftChild());
			queue.add(treeNode);
			inorder(treeNode.getRightChild());
		}
	}
	private void postorder(TreeNode<T> treeNode) {
		// TODO Auto-generated method stub
		if(treeNode!=null){
			postorder(treeNode.getLeftChild());
			postorder(treeNode.getRightChild());
			queue.add(treeNode);
		}
	}
}
