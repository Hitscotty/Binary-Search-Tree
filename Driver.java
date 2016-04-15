package HW6;

/**
 * @author Scotty
 */

import java.lang.reflect.Array;
import java.util.Random;
import java.util.Vector;

public class Driver{
	//stuff to calculate TIME,AVG, and SD
	public static long [] nums;
	//create random to be used for creation of contacts
	static Random rand = new Random();
	
	//Make an empty vector, empty binary search tree of Person objects, and a tree iterator
	//with my binary search tree passed into it
	public static Vector<Person> myVector = new Vector<Person>();
	public static BinarySearchTree<Person, ?> myTree = new BinarySearchTree();
	public static TreeIterator<Person> bst = new TreeIterator<Person>(myTree);
	
	
	private static int size = 0;

	public static int size() {
		return size;
	}

	public static String randomName() {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "w",
				"x", "y", "z" };
		String name = "";
		for (int i = 0; i < 6; i++) {
			name += alphabet[rand.nextInt(25)];

		}
		return name;
	}

	// generate random numbers in form xxx-xxx-xxxx
	public static String randomPhone() {
		String phone = "";
		while (phone.length() < 12) {
			if (phone.length() == 3 || phone.length() == 7) {
				phone += "-";
			}
			phone += rand.nextInt(9);
		}

		return phone;
	}

	public static void generatePersons(int amount) {

		String name;
		String phone;
		Person person;

		for (int i = 0; i < amount; i++) {
			name = randomName();
			phone = randomPhone();

			person = new Person(name, phone);
			myVector.add(person);
			size++;

		}

	}

	public static void display(Vector myVector) {
		for (int i = 0; i < myVector.size(); i++) {
			System.out.println("The value: " + myVector.get(i));

		}
	}
	
	/**
	 * Method which balances the tree by using an iterator to iterate properly the passed in BinaryTree.
	 * Takes binary tree and creates a new organized tree with use of a Vector
	 * @param swag
	 */
	public static void balanceTree(BinarySearchTree<Person, ?> swag){
		// This method should balance the tree if necessary.
		
		BinarySearchTree<Person, ?> balance = new BinarySearchTree();
		TreeIterator<Person> myIter         = new TreeIterator<Person>(balance);
		Vector<Person> newVector            = new Vector<Person>();
		TreeIterator<Person> bst            = new TreeIterator<Person>(myTree);

		TreeNode<Person> node;
		
		//reorganize the vector in  a new vector
		bst.setInorder();
		while (bst.hasNext()) {
			newVector.add(bst.next());			
}

		int first    = 0;
		int last     = newVector.size();
		node         = swag.balanceTree(newVector, first, last);
		balance.root = node;
		TreeIterator<Person> prac = new TreeIterator<Person>(balance);
		
		while(prac.hasNext()){
			System.out.println("The new tree: " + prac.next());
		}
		System.out.println("success!");
		
				
		//find middle value and make root of tree then insert all values
		
	
	}
	

	public static void search(){
		
		Person temp = null;
			for(int i =0; i<myVector.size();i++){
				while(bst.hasNext()){
					temp = bst.next();
					if(temp.getName() == myVector.get(i).getName()){
						System.out.println("Found element: " + temp);
					}
	
				}
		}
			
	}
	
	public static long timeStuff(long start, long finish){
		long time;
		time = finish - start;
		return time;
	}
	
	public static void main(String[] args) {
		long start;
		long finish;
 
		//create 131,071 contacts
		System.out.println("TestCase 1: create 131,071 contacts");
		generatePersons(3);
		System.out.println();

		//displayed my vector to check to see if it worked
		System.out.println("TestCase 2:");
		display(myVector);
		System.out.println();
		
		//created a bst and pass everything in myVector into it
		// insert entries into BST
		System.out.println("TestCase 3: Insert into BST");
		start = System.nanoTime();
		for (int i = 0; i < myVector.size(); i++) {
			myTree.insert(myVector.get(i));
		}
		finish = System.nanoTime();
		System.out.println();

		//use iterator to display 1st 1000 using inorder traversal
		System.out.println("TestCase 4:");
		start = System.nanoTime();
		bst.setInorder();
		int number = 0;
		while (bst.hasNext()) {
			System.out.println("In tree " + number + ": " + bst.next());
			number++;
		}
		finish = System.nanoTime();
		System.out.println();
		
		//measure and display height of tree
		System.out.println("TestCase 5:");
		start = System.nanoTime();
		System.out.println("The height is: " + myTree.treeHeight());
		finish = System.nanoTime();
		System.out.println();
		
		//Balance the BinarySearchTree<Person>.
		System.out.println("TestCase 6:");
		boolean isBalanced = myTree.isBalanced();
		System.out.println("Balance: " + isBalanced);
		start = System.nanoTime();
		balanceTree(myTree); 
		finish = System.nanoTime();
		isBalanced = myTree.isBalanced();
		System.out.println("After balance method: " + myTree.treeHeight());
		System.out.println();
		
		
		//Search your BinarySearchTree<Person> for all the Person entries in your Vector<Person>.
		System.out.println("TestCase 7:");
		start = System.nanoTime();
		search();
		finish = System.nanoTime();
		System.out.println();
		
		
		//Use the TreeIterator<Person> to display the first 1000 entries using inOrder traversal
		System.out.println("TestCase 8:");
		start = System.nanoTime();
		bst.setInorder();
		int count = 0;
		while(bst.hasNext() && count<1000){
			System.out.println(bst.next());
			count++;
		}
		finish = System.nanoTime();
		System.out.println();
		
		//Measure and display the height of the BinarySearchTree<Person>.
		System.out.println("TestCase 9:");
		start = System.nanoTime();
		System.out.println("The height is: " + myTree.treeHeight());
		finish = System.nanoTime();
		System.out.println();
		
	}

}
