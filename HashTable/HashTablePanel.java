package htable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class HashTablePanel extends JPanel{

    private JLabel title;
    private JButton insertButton, deleteButton, searchButton;
    private JTextField insertField, deleteField, searchField;
    private JPanel buttonPanel;
    private JRadioButton linearHash, quadraticHash, doubleHash;
    HashTable htbl = new HashTable(19);
    private int indexEdited;

    public HashTablePanel(){

	title = new JLabel("Hash Table");
	title.setFont(new Font("Arial", Font.PLAIN, 20));
        insertButton = new JButton ("Insert");
        deleteButton = new JButton ("Delete");
	searchButton = new JButton ("Search");
        insertField = new JTextField(3);
        deleteField = new JTextField(3);
	searchField = new JTextField(3);
        linearHash = new JRadioButton("Linear Probing");
        quadraticHash = new JRadioButton("Quadratic Probing");
        doubleHash = new JRadioButton("Double Hashing");
        ButtonGroup hashingType = new ButtonGroup();
        hashingType.add(linearHash);
        hashingType.add(quadraticHash);
        hashingType.add(doubleHash);
	linearHash.setSelected(true);

	EventListener listener = new EventListener();
	insertButton.addActionListener(listener);
	deleteButton.addActionListener(listener);
	searchButton.addActionListener(listener);
	
        setPreferredSize(new Dimension(600,500));
        setBackground(Color.gray);

	JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setPreferredSize(new Dimension(150, 490));
        buttonPanel.setBackground(Color.white);
	buttonPanel.add(title);
	buttonPanel.add(Box.createVerticalStrut(80));
        buttonPanel.add(insertButton);
        buttonPanel.add(insertField);
	buttonPanel.add(searchButton);
	buttonPanel.add(searchField);
        buttonPanel.add(deleteButton);
	buttonPanel.add(deleteField);
        buttonPanel.add(linearHash);
	buttonPanel.add(quadraticHash);
	buttonPanel.add(doubleHash);

        DiagramPanel diagramPanel = new DiagramPanel();

	add(buttonPanel);
        add(diagramPanel);
    }

    private class EventListener implements ActionListener{

	public void actionPerformed(ActionEvent event){

	    Object source = event.getSource();
	    //int insertValue = Integer.parseInt(insertField.getText());

	    if(source == insertButton){
		if(linearHash.isSelected()){
		    htbl.linearInsert(Integer.parseInt(insertField.getText()));
		    htbl.print();
		    indexEdited = htbl.linearSearch(Integer.parseInt(insertField.getText()));
		    repaint();
		}else if(doubleHash.isSelected()){
		    htbl.doubleInsert(Integer.parseInt(insertField.getText()));
		    htbl.print();
		    repaint();
		}else{
		    htbl.quadInsert(Integer.parseInt(insertField.getText()));
		    htbl.print();
		    repaint();
		}		
	    }else if(source == searchButton){
		if(linearHash.isSelected()){
		    htbl.linearSearch(Integer.parseInt(searchField.getText()));
		    htbl.print();
		    repaint();
		}else if(doubleHash.isSelected()){
		    htbl.doubleSearch(Integer.parseInt(searchField.getText()));
		    htbl.print();
		    repaint();
		}else{
		    htbl.quadSearch(Integer.parseInt(searchField.getText()));
		    htbl.print();
		    repaint();
		}		
	    }else if(source == deleteButton){
		if(linearHash.isSelected()){
		    htbl.linearDelete(Integer.parseInt(deleteField.getText()));
		    htbl.print();
		    repaint();
		}else if(doubleHash.isSelected()){
		    htbl.doubleDelete(Integer.parseInt(deleteField.getText()));
		    htbl.print();
		    repaint();
		}else{
		    htbl.quadDelete(Integer.parseInt(deleteField.getText()));
		    htbl.print();
		    repaint();
		}
		
	    }
	}

	// public void paintNum(Graphics g){

	//     if(data[indexEdited] <= 9){
	// 	g.drawString(Integer.toString(data[indexEdited]), 115, 68 + (indexEdited * 40));
	//     }else{
	// 	g.drawString(Integer.toString(data[indexEdited]), 285, 68 + ((indexEdited - 10) * 40));
	//     }

	// }
	    
    }

    @SuppressWarnings("serial")
    private class DiagramPanel extends JPanel{

	// HashTable displayTable = new HashTable(19);
	private int data[] = htbl.getTable();
	
        

        public DiagramPanel(){
            setPreferredSize(new Dimension(430, 490));
            setBackground(Color.white);

	   
        }

	public void paintComponent(Graphics g){

	    super.paintComponent(g);
	    for(int i = 0; i <= 9; i++){

		g.drawRect(90, 40 + (i * 40), 80, 40);
		g.setFont(new Font("serif", Font.PLAIN, 15));
		g.drawString(Integer.toString(i), 60, 65 + (i * 40));
		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString(Integer.toString(data[i]), 115, 68 + (i * 40));
	    }

	    for(int i = 10; i <= 18; i++){
		int y = i - 10;

		g.drawRect(260, 40 + (y * 40), 80, 40);
		g.setFont(new Font("serif", Font.PLAIN, 15));
		g.drawString(Integer.toString(i), 230, 65 + (y * 40));
		g.setFont(new Font("arial", Font.PLAIN, 20));
		g.drawString(Integer.toString(data[i]), 285, 68 + (y * 40));
	    }
	    

	}

	

    }

}
    

    


