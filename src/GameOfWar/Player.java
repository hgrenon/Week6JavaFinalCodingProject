package GameOfWar;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand = new LinkedList<Card>();
	private int score = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void draw(Deck deck) {
		hand.add(deck.draw());
	}

	public List<Card> getHand() {
		return hand;
	}
	public Card flip() {
		return hand.remove(0);
	}
	public void incrementScore() {
		score = getScore() + 1;
	}
	public int getScore() {
		return score;
	}

	public void createHand() {
		for(int rank = 1; rank <= Card.valuesArray.length; rank++) {
			}
	}
	public void describe() {
		for(int i = 0; i < hand.size(); i++) {
			System.out.println(hand.get(i).describe());
		}
		
	}

}




