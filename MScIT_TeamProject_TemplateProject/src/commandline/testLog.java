package commandline;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;


public class testLog {

	private final String logFileName = "toptrumps.log";
	private PrintWriter writeToLog;

	public testLog() {

		try {
			writeToLog = new PrintWriter(logFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	public void logDeck(Deck deck) {

		writeToLog.write("The contents of the deck is as follows:\r\n\r\n");
		Stack<Card> deckOfCards = deck.getStack();

		for (int i = 0; i < deckOfCards.size(); i++) {
			Card card = deckOfCards.get(i);
			writeToLog.write(card + "\r\n\r\n");
		}

	}
	

	public void playerDecks(ArrayList<Player> players) {

		for (int i = 0; i < players.size(); i++) {

			String name = players.get(i).getName();
			writeToLog.write("User deck: " + name + "\r\n\r\n");
			Stack<Card> deck = players.get(i).getDeck();

			if (deck.size() == 0) {
				writeToLog.write(name + " has no more cards!");
			}

			for (int a = 0; a < deck.size(); a++) {

				Card userCard = deck.get(a);
				writeToLog.write(userCard + "\r\n\r\n");
			}

		}
	}

	public void communalPile(ArrayList<Card> winnerPile) {

		writeToLog.write("The communal pile currently contains the following:\r\n");

		for (int i = 0; i < winnerPile.size(); i++) {

			Card communalCard = winnerPile.get(i);
			writeToLog.write(communalCard + "\r\n");

		}
	}

	public void cardsInPlay(ArrayList<Card> topCards) {

		writeToLog.write("The current cards in play are:\r\n\r\n");

		for (int i = 0; i < topCards.size(); i++) {

			Card communalCard = topCards.get(i);
			writeToLog.write(communalCard + "\r\n\r\n");

		}
	}

	public void categoryChosen(ArrayList<Player> players) {
			
		for (int i = 0; i < players.size(); i++) {
			String name = players.get(i).getName();
			int value = players.get(i).getSelectedValue();
			writeToLog.write(name + "'s" + "category" + "=" + value + "\r\n");

		}
	}



	public void logRoundWinner(Player roundWinner) {

		String roundWin = roundWinner.getName();
		writeToLog.write("\r\nThe winner of the round is " + roundWin + " !\r\n");

	}


	public void logGameWinner(Player gameWinner) {

		String gameWin = gameWinner.getName();
		writeToLog.write("\r\nThe winner of the game is " + gameWin + " !!!\r\n");

	}


	public void close() {
		writeToLog.close();
	}

}
