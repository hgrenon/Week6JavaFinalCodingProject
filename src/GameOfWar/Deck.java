package GameOfWar;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
		
	List<Card> cards = new LinkedList<Card>();
	
public Deck() {
	for(int i = 0; i < Card.suitArray.length; i++) {
		for(int j = 0; j <Card.valuesArray.length; j++) {
			Card card = new Card(Card.valuesArray[j] + " of " + Card.suitArray[i], j);
			cards.add(card);
		}
	}
}

public void shuffle() {
		Collections.shuffle(cards);

	
}
public Card draw() {
	return cards.remove(0);
}

}
