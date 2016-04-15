package HW6;

/**
 * Class initializes what a node in this tree structure will look like.
 * Every node that represents this tree has a left child and a right child.
 * @author Scotty
 *
 * @param <T>
 */
public class TreeNode<T> {

	private T item;
	private	TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	public TreeNode(T newItem){
		setItem(newItem);
		setLeftChild(null);
		setRightChild(null);
	}
	
	public TreeNode( T newItem, TreeNode<T> left, TreeNode<T> right){
		setItem(newItem);
		setLeftChild(left);
		setRightChild(right);
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
}
