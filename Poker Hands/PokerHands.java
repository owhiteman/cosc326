import java.util.Scanner;
import java.util.regex.*; 
public class PokerHands{

    private static String[] validInput = {"1","2","3","4","5","6","7","8","9","10","11","12","13","T","J","Q","K","A"};
    
    public static void main(String[]args){
	Scanner scan = new Scanner(System.in);
	while(scan.hasNextLine()){
	    String s = scan.nextLine();
	    String original = s;
	    StringBuilder sb = new StringBuilder();
	    sb.append(s);
	    for(int i = 0; i < sb.length(); i++){
		char upper = Character.toUpperCase(sb.charAt(i));
		sb.setCharAt(i, upper);			
	    }
	    if(fiveSections(s)){				
		for(int i = 0; i < sb.length(); i++){
		    if(sb.charAt(i) == '/' || sb.charAt(i) == '-'){
			sb.setCharAt(i, ' ');
		    }
		}		
		if(suited(sb.toString())){
		    s = sb.toString();
		    String[] cards = s.split(" ");
		    if(validCard(cards)){
			//System.out.println(s + ":");
			s = conversion(s);
			s = conversionForRank(s);
		        s = rank(s);
			s = conversion(s);
			if(noDuplicates(s)){
			    System.out.println(s);
			}else System.out.println("Invalid: " + original);
		    }else System.out.println("Invalid: " + original);
		}else System.out.println("Invalid: " + original);
	    }else System.out.println("Invalid: " + original);	    
	}
    }

    //Checks if the input is broken into five sections
    public static boolean fiveSections(String input){
	Pattern p = Pattern.compile("[a-zA-Z0-9]+[\\s/-][a-zA-Z0-9]+[\\s/-][a-zA-Z0-9]+[\\s/-][a-zA-Z0-9]+[\\s/-][a-zA-Z0-9]+");  
	Matcher m = p.matcher(input);  
	boolean b = m.matches();
	return b;	
    }

    //Checks if the five sections have suits
    public static boolean suited(String input){
	Pattern p = Pattern.compile(".*[CDHS]\\s.*[CDHS]\\s.*[CDHS]\\s.*[CDHS]\\s.*[CDHS]");  
	Matcher m = p.matcher(input);  
	boolean b = m.matches();
	return b;
    }

    //Checks if it is a valid input card
    public static boolean validCard(String[] inputs){
	String compare;
        int correctCards = 0;
	for(String hand : inputs){
	    compare = hand.substring(0, hand.length() - 1);
	    for(String check : validInput){
		if(compare.equals(check)){
		    correctCards++;
		}
	    }	    
	}
	if(correctCards != 5){
	    return false;
	}
	
	return true;
    }

    //Convert Cards to rank them
    public static String conversionForRank(String input){
	StringBuilder sb = new StringBuilder();
	sb.append(input);

	for(int i = 0; i < sb.length(); i++){
	    if(sb.charAt(i) == 'T'){
	        sb.replace(i, i+1, "10");
	    }else if(sb.charAt(i) == 'J'){
		sb.replace(i, i+1, "11");
	    }else if(sb.charAt(i) == 'Q'){
		sb.replace(i, i+1, "12");
	    }else if(sb.charAt(i) == 'K'){
		sb.replace(i, i+1, "13");
	    }else if(sb.charAt(i) == 'A' || sb.charAt(i) == '1' && sb.charAt(i+1) > 64 && sb.charAt(i - 1) != '1'){
		sb.replace(i, i+1, "14");
	    }
	}	
	input = sb.toString();
	return input;
    }

    //Convert cards to present
    public static String conversion(String input){
	StringBuilder sb = new StringBuilder();
	sb.append(input);

	for(int i = 0; i < sb.length(); i++){
	    if(sb.charAt(i) == 'T'){
	        sb.replace(i, i+1, "10");
	    }else if(sb.charAt(i) == '1' && sb.charAt(i + 1) == '1'){
		sb.replace(i, i+2, "J");
	    }else if(sb.charAt(i) == '1' && sb.charAt(i + 1) == '2'){
		sb.replace(i, i+2, "Q");
	    }else if(sb.charAt(i) == '1' && sb.charAt(i + 1) == '3'){
		sb.replace(i, i+2, "K");
	    }else if(sb.charAt(i) == '1' && sb.charAt(i + 1) == '4'){
		sb.replace(i, i+2, "A");
	    }else if(sb.charAt(i) == '1' && sb.charAt(i + 1) != '0'){
		sb.setCharAt(i,'A');
	    }
	}	
	input = sb.toString();
	return input;
    }

    //Assigning value to cards then sorting them
    public static String rank(String input){
	String[] cards = input.split(" ");
	int[] sortingCards = new int[5];
	//Assigning value to cards and storing value in another array
	for(int i = 0;i < cards.length; i++){
	    int value;
	    if(cards[i].length() == 2){
		value = (Integer.parseInt(cards[i].substring(0,1)) * 100);
		value += cards[i].charAt(1);
		sortingCards[i] = value;
	    }else{
		value = (Integer.parseInt(cards[i].substring(0,2)) * 100);
		value += cards[i].charAt(2);
		sortingCards[i] = value;
	    }
	}
	//Sorting the value array with selection sort and performing the same swaps on the card array
	for(int i = 0; i < cards.length; i++){
	    int mindex = i;
	    for(int j = i+1; j < cards.length; j++){
		if(sortingCards[j] < sortingCards[mindex]){
		    mindex = j;				   
		}		
	    }
	    int temp = sortingCards[mindex]; 
	    sortingCards[mindex] = sortingCards[i]; 
	    sortingCards[i] = temp;
	    String tempCard = cards[mindex];
	    cards[mindex] = cards[i];
	    cards[i] = tempCard;
	}
	StringBuilder sb = new StringBuilder();
	
	for(String card : cards){
	     sb.append(card + " ");
	}
	sb.delete(input.length(), input.length()+1);
        input = sb.toString();
	return input;
    }

    //Making sure there are no duplicate cards
    public static boolean noDuplicates(String input){
	String[] cards = input.split(" ");
	for(int i = 0; i < 5; i++){
	    for(int j = i + 1; j < 5; j++){
		if(cards[i].equals(cards[j])){
		    return false;
		}
	    }
	}
	return true;
    }


}
