package HW6;

public class Person extends KeyedItem<String> {

	private String name; // Will be used as the Search Key.
	private String phoneNumber;// Format xxx-xxx-xxxx, where every x is in the range 0-9.
	private static int size = 0;
	
	//constructor to create a person

	public Person(String name, String phone){
		super(name);
		this.name = name;
		this.phoneNumber = phone;
		
		size++;
	}
	public boolean equals(Object obj){
		if(this.name == obj && this.phoneNumber == obj){
			return true;
		}
		return false;
	}
	
	// change name or phone number at any moment
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(String phone){
		this.phoneNumber = phone;
	}
	
	//display info
	public String toString(){
		return getName() + ": " + phoneNumber;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
