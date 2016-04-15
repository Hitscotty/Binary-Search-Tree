package HW6;

public class BinaryTree<T> extends BinaryTreeBasis<T>{

	public BinaryTree(){
	}
	
	public BinaryTree(T rootItem){
		super(rootItem);
		
	}
	
	public BinaryTree(T rootItem, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
		root = new TreeNode<T>(rootItem,null,null);
		attachLeftSubtree(leftTree);
		attachRightSubtree(rightTree);
	}

	@Override
	public void setRootItem(T newItem) {
		// TODO Auto-generated method stub
		if(root!= null){
			root.setItem(newItem);
		}else{
			root = new TreeNode<T> (newItem, null,null);
		}
	}
	
	public void attachLeft(T newItem){
		if(!isEmpty() && root.getLeftChild() == null){
			//assertion: nonempty tree; no left child
			root.setLeftChild(new TreeNode<T>(newItem,null,null));
		}
	}

	public void attachRight(T newItem){
		if(!isEmpty() && root.getRightChild() == null){
			//assertion: nonempty tree; no right child
			root.setRightChild(new TreeNode<T>(newItem,null,null));
		}
	}
	
	void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new TreeException("TreeException: Empty Tree");
		}else if(root.getRightChild() != null){
			//a right subtree already exists; it should have been deleted first
			throw new TreeException("TreeException: cannot overwrite left subtree ");
		}else{
			//assertion: nonemty tree; no left child
			root.setRightChild(rightTree.root);
			//don't want to leave multiple entry points into our tree
			rightTree.makeEmpty();
		}
		
	}

	private void attachLeftSubtree(BinaryTree<T> leftTree) {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new TreeException("TreeException: Empty Tree");
		}else if(root.getLeftChild() != null){
			//a left subtree already exists; it should have been deleted first
			throw new TreeException("TreeException: cannot overwrite right subtree");
		}else{
			//assertion: nonemty tree; no right child
			root.setLeftChild(leftTree.root);
			//don't want to leave multiple entry points into our tree
			leftTree.makeEmpty();
		}
	}
	
	protected BinaryTree(TreeNode<T> rootNode){
		root = rootNode;
	}
	
	public BinaryTree<T> detachLeftSubtree() throws TreeException{
		if(isEmpty()){
			throw new TreeException("TreeException:  Empty Tree");
		}else{
			//create a new binary tree that has roots left node as its root
			BinaryTree<T> leftTree;
			leftTree = new BinaryTree<T>(root.getLeftChild());
			root.setLeftChild(null);
			return leftTree;
		}
	}
	public BinaryTree<T> detachRightSubtree() throws TreeException{
		if(isEmpty()){
			throw new TreeException("TreeException:  Empty Tree");
		}else{
			BinaryTree<T> rightTree;
			rightTree = new BinaryTree<T>(root.getRightChild());
			root.setRightChild(null);
			return rightTree;
		}
	}
}
