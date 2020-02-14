package commandline;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class tsetLog {

	private final String logFileName = "toptrumps.log";
	private PrintWriter writeToLog;

	public Log() {

		try {
			writeToLog = new PrintWriter(logFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	public void logDeck(Deck deck) {

		writeToLog.write("The contents of the deck is as follows:\r\n\r\n");
		ArrayList<Card> deckOfCards = deck.getStack();

		for (int i = 0; i < deckOfCards.size(); i++) {
			String card = deckOfCards.get(i).cardToString();
			writeToLog.write(card + "\r\n\r\n");
		}
		refresh();
	}
	

	public void playerDecks(ArrayList<Player> players) {

		for (int i = 0; i < players.size(); i++) {

			String name = players.get(i).getName();
			writeToLog.write("User deck: " + name + "\r\n\r\n");
			ArrayList<Card> deck = players.get(i).getDeck();

			if (deck.size() == 0) {
				writeToLog.write(name + " has no more cards!");
			}

			for (int a = 0; a < deck.size(); a++) {

				String userCard = deck.get(j).cardToString();
				writeToLog.write(userCard + "\r\n\r\n");
			}
			refresh();
		}
	}

	public void communalPile(ArrayList<Card> winnerPile) {

		writeToLog.write("The communal pile currently contains the following:\r\n");

		for (int i = 0; i < winnerPile.size(); i++) {

			String communalCard = winnerPile.get(i).cardToString();
			writeToLog.write(communalCard + "\r\n");

		}
		refresh();
	}

	public void cardsInPlay(ArrayList<Card> topCards) {

		writeToLog.write("The current cards in play are:\r\n\r\n");

		for (int i = 0; i < topCards.size(); i++) {

			String communalCard = topCards.get(i).cardToString();
			writeToLog.write(communalCard + "\r\n\r\n");

		}
		refresh();
	}

	public void categoryChosen(String category, ArrayList<Player> players) {

		String c = category;

		writeToLog.write("The chosen category is: " + category + "\r\n");

//		for (int i = 0; i < players.size(); i++) {
//
//			String name = players.get(i).getName();
//			int value = players.get(i).getDeck().getValues(value);
//			writeToLog.write(name + "'s " + c + " =" + value + "\r\n");
//		}
	}



	public void logRoundWinner(Player roundWinner) {

		String roundWin = roundWinner.getName();
		writeToLog.write("\r\nThe winner of the round is " + roundWin + " !\r\n");
		refresh();
	}


	public void logGameWinner(Player gameWinner) {

		String gameWin = gameWinner.getName();
		writeToLog.write("\r\nThe winner of the game is " + gameWin + " !!!\r\n");
		refresh();
	}


	public void close() {
		writeToLog.close();
	}


	public void refresh() {
		StringBuilder refresh = new StringBuilder();

		for (int i = 0; i < 50; i++) {
			refresh.append("-");
		}
		String d = refresh.toString();
		writeToLog.write("\r\n" + d + "\r\n");
	}

}
