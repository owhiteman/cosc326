package htable;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String [] args){
		HashTable table = new HashTable(11);
		JFrame frame = new JFrame("Hash Table");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new HashTablePanel());
		frame.pack();
		frame.setVisible(true);
		
//		table.linearInsert(7);
//		table.linearInsert(6);
//		table.linearInsert(7);
//		table.linearInsert(2);
//		table.linearInsert(1);
//		table.linearInsert(2);
//		table.linearInsert(4);
//		table.linearInsert(2);
//		table.linearInsert(3);
//		
//		table.print();
		
//		table.quadInsert(2);
//		table.quadInsert(3);
//		table.quadInsert(3);
//		table.quadInsert(4);
//		table.quadInsert(5);
//		table.quadInsert(7);
//		table.quadInsert(2);
//		table.quadInsert(8);
//		table.quadInsert(1);
//		
//		table.print();
//		
//		table.quadDelete(8);
//		table.print();
//		System.out.println("Specified number stored at index: " + table.quadSearch(4));
		
//		table.doubleInsert(7);
//		table.doubleInsert(7);
//		table.doubleInsert(7);
//		table.doubleInsert(7);
//		table.print();
		
		
	}

}
