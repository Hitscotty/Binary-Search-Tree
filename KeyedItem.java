package HW6;

public class KeyedItem<KT extends Comparable<? super KT>>{
	private KT searchKey;
	
	public KeyedItem(KT key){
		searchKey = key;
	}
	
	public KT getKey(){
		return searchKey;
	}
	
	public int compareTo(KT searchKey) {
		// TODO Auto-generated method stub
		return this.searchKey.compareTo(searchKey);
	}
}
