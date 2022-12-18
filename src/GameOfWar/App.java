package GameOfWar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	
	private final List<String> players = List.of("Larry", "Mo", "Curly");
	private Random random = new Random();
	private Player player1;
	private Player player2;
	private Deck deck;
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		selectPlayers();
		createAndShuffleDeck();
		deal();
		play();
		declareWinner();
		
	}
	
	private void selectPlayers() {
		List<String> names = new LinkedList<>(players);
		player1 = selectPlayer(names);
		player2 = selectPlayer(names);
		
		System.out.println(player1.getName() + " is playing " + player2.getName() + ".");
		System.out.println();
	}

	
	private Player selectPlayer(List<String> names) {
		int pos = random.nextInt(names.size());
		String playerName = names.remove(pos);
		return new Player(playerName);
	}
	
	private void createAndShuffleDeck() {
		deck = new Deck();
		deck.shuffle();
		
	}

	private void deal() {
		int size = deck.cards.size();
		for(int index = 0; index < size; index++) {
			if(index % 2 == 0) {
				player1.draw(deck);
			}
			else if(index % 2 != 0) {
				player2.draw(deck);
			}
		}
		
	}
	
	private void play() {
		int numTurns = player1.getHand().size();
		for(int turn = 0; turn < numTurns; turn++) {
			playersFlipCards();
		}
	}
	
	private void playersFlipCards() {
		Card card1 = player1.flip();
		Card card2 = player2.flip();
				
		if(card1.getValue() > card2.getValue()) {
			player1.incrementScore();
		}
		else if(card2.getValue() > card1.getValue()) {
			player2.incrementScore();
		}
		
		System.out.println(player1.getName() + " draws " + card1.describe() + " and " + player2.getName() 
		+ " draws " + card2.describe() + "!");
		
		if(card1.getValue() > card2.getValue()) {
			System.out.println(player1.getName() + " wins this round!!");
		}
		else if(card2.getValue() > card1.getValue()) {
			System.out.println(player2.getName() + " wins this round!!");
		}
		else {
			System.out.println("Boo! This round is a draw.");
		}
		
		System.out.println(player1.getName() + "'s score is now " + player1.getScore() 
		+ " and " + player2.getName() + "'s score is now " + player2.getScore() + ".");
		System.out.println();
	}
	
	private void declareWinner() {
		if(player1.getScore() > player2.getScore()) {
			printWinner(player1);
			printLoser(player2);
		}
		else if(player2.getScore() > player1.getScore()) {
			printWinner(player2);
			printLoser(player1);
		}
		else {
			printTie(player1, player2);
		}
	}

	private void printTie(Player player1, Player player2) {
		System.out.println(player1.getName() + " and " + player2.getName() 
		+ "'s game has ended in a draw with a score of " + player1.getScore() + ".");
		
	}

	private void printLoser(Player loser) {
		System.out.println(loser.getName() + " loses with a score of " + 
				loser.getScore() + ".");
		
	}

	private void printWinner(Player winner) {
		System.out.println(winner.getName() + " wins with a score of " + 
				winner.getScore() + ".");
		
	}


	
}
