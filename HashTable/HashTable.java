package htable;

public class HashTable {
    private int table[];
    private int maxSize;

    public HashTable(int capacity){
	setTable(new int[capacity]);
	this.maxSize = capacity;	
    }

    public void linearInsert(int key){
	int i = 0;
	int index = hash(key, i);
	int original = index;
	while(getTable()[index] != 0){
	    i = i + 1;
	    index = hash(key, i);
	    if(index == original){
		System.out.println("Table full, cannot store");
		return;
	    }
	}
	getTable()[index] = key;
    }
	
    public void quadInsert(int key){
	int i = 0;
	int index = hash(key, i);
	int original = index;
	while(getTable()[index] != 0){
	    i = i + 1;
	    index = hash(key, i * i);
	    if(index == original){
		System.out.println("Table full, cannot store");
		return;
	    }
	}
	getTable()[index] = key;
    }
	
    public void doubleInsert(int key) {

	int i = 0;
	int index = doubleHash(key, i);
	int original = index;
	while (getTable()[index] != 0) {
	    i = i + 1;
	    index = doubleHash(key, i);
	    if (index == original) {
		System.out.println("Hash table is full, not able to insert " + key);
		return;
	    }
	}
	getTable()[index] = key;
    }

    public int linearSearch(int key) {

	int i = 0;
	int index = hash(key, i);
	int original=index;
	while (table[index] != key) {
	    i = i + 1;
	    index = hash(key, i);
	    if (table[index] == 0 || original==index) {
		return -1;
	    }
	}

	return index;
    }

    public int quadSearch(int key) {

	int i = 0;
	int index = hash(key, i);
	int original=index;
	while (table[index] != key) {
	    i = i + 1;
	    index = hash(key, i * i);
	    if (table[index] == 0 || original==index) {
		return -1;
	    }
	}

	return index;
    }
	
    public int doubleSearch(int key) {

	int i = 0;
	int index = doubleHash(key, i);
	int original = index;
	while (table[index] != key) {
	    i = i + 1;
	    index = doubleHash(key, i);
	    if (table[index] == 0 || original == index) {
		return -1;
	    }
	}

	return index;
    }

    public void linearDelete(int key){

	int index= linearSearch(key);
	if(index!=-1){
	    table[index]=0;
	    System.out.println("Key has been deleted successfully.");
	}else{
	    System.out.println("Key not found.");
	}
    }
    public void quadDelete(int key){

	int index= quadSearch(key);
	if(index!=-1){
	    table[index]=0;
	    System.out.println("Key has been deleted successfully.");
	}else{
	    System.out.println("Key not found.");
	}
    }
	
    public void doubleDelete(int key){

	int index= doubleSearch(key);
	if(index!=-1){
	    table[index]=0;
	    System.out.println("Key has been deleted successfully.");
	}else{
	    System.out.println("Key not found.");
	}
    }
	
    public void print() {
	//System.out.print("Hash Table: ");
	if(isEmpty()) {
	    //System.out.print("Empty");
	} else {
	    for(int i = 0; i < maxSize; i++) {
		//				if(table[i] != 0) {
		//System.out.printf("%2d ", table[i]);
		//				}
	    }
	}
	/System.out.print("\n");
    }
	
	
    public boolean isEmpty(){
	return maxSize == 0;
    }


    private int hash(int key, int i){
	int index = (key+i) % maxSize;
	return index;
    }
	
    private int doubleHash(int key, int i) {

	int index = (key + i * hash2(key)) % maxSize;
	return index;
    }

    private int hash2(int key) {
	return 7 - (key % 7);
    }



    public int[] getTable(){
	return table;
    }


    public void setTable(int table[]){
	this.table = table;
    }

    public int getItem(int index){
	return table[index];

    }

}
