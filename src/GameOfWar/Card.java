package GameOfWar;


public class Card {
	
	private String name;
	private int value;
	
	
	public static String[] valuesArray = {"Two", "Three", "Four", "Five", "Six", "Seven", 
					"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		
		
	public static String[] suitArray = {"Hearts", "Spades", "Diamonds", "Clubs"};
	
	
	public Card(String name, int value) {
		setName(name);
		setValue(value);
		
	}
		
	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String describe() {
		return name;
	}
	
}
