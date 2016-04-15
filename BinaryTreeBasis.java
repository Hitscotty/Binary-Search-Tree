package HW6;

public abstract class BinaryTreeBasis<T> {
	protected TreeNode<T> root;
	
	//default constructor creates null
	public BinaryTreeBasis(){
		root = null;
	}
	
	//constructor to create start of tree
	public BinaryTreeBasis(T rootNode){
		root = new TreeNode<T>(rootNode,null,null);
	}
	
	public boolean isEmpty(){
		//returns true if tree is empty else returns false
		return root == null;
	}
	
	public void makeEmpty(){
		//removes all nodes from tree
		root = null;
	}
	
	public T getRootItem() throws TreeException{
		if(root==null){
			throw new TreeException( "Tree Exception: Empty Tree");
		}else{
			return root.getItem();
		}
	}
	public abstract void setRootItem(T newItem);
	

}
