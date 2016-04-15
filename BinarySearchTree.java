package HW6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import HW6.KeyedItem;

public class BinarySearchTree<T extends KeyedItem<KT>, KT extends Comparable<? super KT>>
		extends BinaryTreeBasis<T> {

	public BinarySearchTree() {

	}

	public BinarySearchTree(T rootItem) {
		super(rootItem);
	}

	public void setRootItem(T newItem) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void insert(T newItem) {
		root = insertItem(root, newItem);
	}

	public T retrieve(KT searchKey) {
		return retrieveItem(root, searchKey);
	}

	public void delete(KT searchKey) throws TreeException {
		root = deleteItem(root, searchKey);
	}

	public void delete(T item) throws TreeException {
		root = deleteItem(root, item.getKey());
	}

	
	protected TreeNode<T> insertItem(TreeNode<T> tNode, T newItem) {
		TreeNode<T> newSubtree;
		if (tNode == null) {
			// position of insertion found; insert after leaf
			// create a new node
			tNode = new TreeNode<T>(newItem, null, null);
			return tNode;
		}
		T nodeItem = tNode.getItem();
		// search for the insertion position
		if (newItem.getKey().compareTo(nodeItem.getKey()) < 0) {
			// search the left subtree
			newSubtree = insertItem(tNode.getLeftChild(), newItem);
			tNode.setLeftChild(newSubtree);
			return tNode;
		} else { // search right treee
			newSubtree = insertItem(tNode.getRightChild(), newItem);
			tNode.setRightChild(newSubtree);
			return tNode;
		}

	}

	protected T retrieveItem(TreeNode<T> tNode, KT searchKey) {
		T treeItem;

		if (tNode == null) {
			treeItem = null;
		} else {
			T nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getKey()) == 0) {
				// item is in the root of some subtree
				treeItem = tNode.getItem();
			} else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
				// search the left subtree
				treeItem = retrieveItem(tNode.getLeftChild(), searchKey);
			} else { // search the right subtree
				treeItem = retrieveItem(tNode.getRightChild(), searchKey);
			}
		}
		return treeItem;

	}

	protected TreeNode<T> deleteItem(TreeNode<T> tNode, KT searchKey) {
		// calls delete Node
		TreeNode<T> newSubtree;
		if (tNode == null) {
			throw new TreeException("TreeException:Item is now found");
		} else {
			T nodeItem = tNode.getItem();
			if (searchKey.compareTo(nodeItem.getKey()) == 0) {
				// item is in the root of some subtree
				tNode = deleteNode(tNode); // delete the item
			}
			// else search for the item
			else if (searchKey.compareTo(nodeItem.getKey()) < 0) {
				newSubtree = deleteItem(tNode.getLeftChild(), searchKey);
				tNode.setLeftChild(newSubtree);
			} else {// search the right tree
				newSubtree = deleteItem(tNode.getRightChild(), searchKey);
				tNode.setRightChild(newSubtree);

			}
		}
		return tNode;

	}

	
	protected TreeNode<T> deleteNode(TreeNode<T> tNode) {
		// Algorithm note: there are four cases to consider:
		// the Tnode is a leaf
		// the Tnode has no left child
		// the Tnode has no right child
		// The Tnode has two Children
		// Call: findLeftMost and deleteLeftMost
		T replacementItem;

		// test for a leaf
		if ((tNode.getLeftChild() == null) && (tNode.getRightChild() == null)) {
			return null;
		}

		// test for no left child
		else if (tNode.getLeftChild() == null) {
			return tNode.getRightChild();
		}// end if no left child

		// test for no right child
		else if (tNode.getRightChild() == null) {
			return tNode.getLeftChild();
		}
		// there are two children
		else {
			replacementItem = findLeftmost(tNode.getRightChild());
			tNode.setItem(replacementItem);
			tNode.setRightChild(deleteLeftmost(tNode.getRightChild()));
			return tNode;
		}
	}

	/**
	 * Travels down tree from root asking: is there a left child 
	 * if there is a left child it continues until reaching a leaf
	 * @param tNode
	 * @return
	 */
	protected T findLeftmost(TreeNode<T> tNode) {
		if (tNode.getLeftChild() == null) {
			return tNode.getItem();
		} else {
			return findLeftmost(tNode.getLeftChild());
		}
	}

	/**
	 * finds left most child until reaching a leaf and deletes that item
	 * @param tNode
	 * @return
	 */
	protected TreeNode<T> deleteLeftmost(TreeNode<T> tNode) {
		if (tNode.getLeftChild() == null) {
			return tNode.getRightChild();
		} else {
			tNode.setLeftChild(deleteLeftmost(tNode.getLeftChild()));
			return tNode;
		}
	}

	public int treeHeight() {
		// This method returns the height of the tree.
		// base case
		int heightLeft = 1;
		int heightRight = 1;
		TreeNode<T> currentRoot = root;

		if (root == null) {
			return 0;
		}
		while (currentRoot.getLeftChild() != null) {
			currentRoot = currentRoot.getLeftChild();
			heightLeft++;
		}
		currentRoot = root;

		while (currentRoot.getRightChild() != null) {
			currentRoot = currentRoot.getRightChild();
			heightRight++;
		}
		if (heightLeft > heightRight) {
			return heightLeft;
		} else {
			return heightRight;
		}

	}

	public boolean isBalanced() {
		// This method returns true if the tree is balanced, false otherwise.
		int heightLeft = 1;
		int heightRight = 1;
		TreeNode<T> currentRoot = root;

		if (root == null) {
			return true;
		}
		while (currentRoot.getLeftChild() != null) {
			currentRoot = currentRoot.getLeftChild();
			heightLeft++;
		}
		currentRoot = root;

		while (currentRoot.getRightChild() != null) {
			currentRoot = currentRoot.getRightChild();
			heightRight++;
		}
		if (heightLeft - 1 == heightRight || heightLeft == heightRight - 1
				|| heightLeft == heightRight) {
			return true;
		} else {
			return false;
		}
	}

	
	public TreeNode<Person> balanceTree(Vector myVector, int first, int last) {
		TreeNode<Person> Node;
		
		
		int mid;
		if (first <= last) {
			mid = (first + last) / 2;
			
			Node = balanceTree(myVector, first, (mid - 1));
			Node = balanceTree(myVector, (mid + 1), last);
		} else {
			return null;
		}
		return Node;
	}
	
	

}
