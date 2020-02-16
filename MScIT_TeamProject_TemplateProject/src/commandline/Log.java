package commandline;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;


public class Log {

    private final String logFileName = "toptrumps.log";
    private PrintWriter pw;

    public Log() {
        try {
            pw = new PrintWriter(logFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void writeDeck(Deck deck) {

        pw.write("The contents of the complete deck:\r");

        for (int i = 0; i < deck.getStack().size(); i++) {
            if (deck.getStack().get(i).getName().length() < 10) {
                pw.write(deck.getStack().get(i).getName() + "\t\t");
            } else {
                pw.write(deck.getStack().get(i).getName() + "\t");
            }
            pw.write("Size: " + deck.getStack().get(i).getSize() + "\t");
            pw.write("Speed: " + deck.getStack().get(i).getSpeed() + "\t");
            pw.write("Range: " + deck.getStack().get(i).getRange() + "\t");
            pw.write("Firepower: " + deck.getStack().get(i).getFirepower() + "\t");
            pw.write("Cargo: " + deck.getStack().get(i).getCargo() + "\r");
        }

        pw.write("\r -------------------------------------------------------------------------------------------------------- \r\r");

    }

    public void writeShuffle(Deck deck) {
        pw.write("After shuffle:\r");

        for (int i = 0; i < deck.getStack().size(); i++) {
            if (deck.getStack().get(i).getName().length() < 10) {
                pw.write(deck.getStack().get(i).getName() + "\t\t");
            } else {
                pw.write(deck.getStack().get(i).getName() + "\t");
            }
            pw.write("Size: " + deck.getStack().get(i).getSize() + "\t");
            pw.write("Speed: " + deck.getStack().get(i).getSpeed() + "\t");
            pw.write("Range: " + deck.getStack().get(i).getRange() + "\t");
            pw.write("Firepower: " + deck.getStack().get(i).getFirepower() + "\t");
            pw.write("Cargo: " + deck.getStack().get(i).getCargo() + "\r");
        }

        pw.write("\r -------------------------------------------------------------------------------------------------------- \r\r");
    }


    public void writePlayerDecks(ArrayList<Player> players) {

        for (int i = 0; i < players.size(); i++) {

            pw.write("----- Player: " + players.get(i).getName() + " ----- Left Cards: " + players.get(i).getDeck().size() + " ----- \r");

            for (int j = 0; j < players.get(i).getDeck().size(); j++) {
                if (players.get(i).getDeck().get(j).getName().length() < 9) {
                    pw.write(players.get(i).getDeck().get(j).getName() + "\t\t");
                } else {
                    pw.write(players.get(i).getDeck().get(j).getName() + "\t");
                }
                pw.write("Size: " + players.get(i).getDeck().get(j).getSize() + "\t");
                pw.write("Speed: " + players.get(i).getDeck().get(j).getSpeed() + "\t");
                pw.write("Range: " + players.get(i).getDeck().get(j).getRange() + "\t");
                pw.write("Firepower: " + players.get(i).getDeck().get(j).getFirepower() + "\t");
                pw.write("Cargo: " + players.get(i).getDeck().get(j).getCargo() + "\r");
            }
            pw.write("--------------------------------------------------------- \r");
        }

        pw.write("\r -------------------------------------------------------------------------------------------------------- \r\r");

    }

    public void writeCommonPile(Stack<Card> commonPile) {

        if (commonPile.size() == 0) {
            pw.write("The communal pile currently contains NOTHING\r\n");
        } else {
            pw.write("The communal pile currently contains the following:\r\n");

            for (int i = 0; i < commonPile.size(); i++) {
                if (commonPile.get(i).getName().length() < 10) {
                    pw.write(commonPile.get(i).getName() + "\t\t");
                } else {
                    pw.write(commonPile.get(i).getName() + "\t");
                }
                pw.write("Size: " + commonPile.get(i).getSize() + "\t");
                pw.write("Speed: " + commonPile.get(i).getSpeed() + "\t");
                pw.write("Range: " + commonPile.get(i).getRange() + "\t");
                pw.write("Firepower: " + commonPile.get(i).getFirepower() + "\t");
                pw.write("Cargo: " + commonPile.get(i).getCargo() + "\r");
            }
        }


        pw.write("\r -------------------------------------------------------------------------------------------------------- \r\r");

    }

    public void writeCurrentCard(ArrayList<Player> players, Player player) {

        pw.write("The current cards in play are:\r\r");

        for (int i = 0; i < players.size(); i++) {

            pw.write("Player: " + players.get(i).getName() + " ---> ");

            if (players.get(i).getDeck().peek().getName().length() < 10) {
                pw.write(players.get(i).getDeck().peek().getName() + "\t\t");
            } else {
                pw.write(players.get(i).getDeck().peek().getName() + "\t");
            }
            pw.write("Size: " + players.get(i).getDeck().peek().getSize() + "\t");
            pw.write("Speed: " + players.get(i).getDeck().peek().getSpeed() + "\t");
            pw.write("Range: " + players.get(i).getDeck().peek().getRange() + "\t");
            pw.write("Firepower: " + players.get(i).getDeck().peek().getFirepower() + "\t");
            pw.write("Cargo: " + players.get(i).getDeck().peek().getCargo() + "\r");

        }

        pw.write("And Now Turn is: " + player.getName() + "\r");

        pw.write("\r -------------------------------------------------------------------------------------------------------- \r\r");
    }

    public void writeSelectCategory(ArrayList<Player> players, Player player, int i) {

        pw.write(player.getName() + " choose category " + player.getDeck().peek().properties[i] + ": " + player.getDeck().peek().getValues(i) + "\r\r");

        for (int j = 0; j < players.size(); j++) {
            if (players.get(j) != player) {
                pw.write(players.get(j).getName() + " choose category " + players.get(j).getDeck().peek().properties[i] + ": " + players.get(j).getDeck().peek().getValues(i) + "\r");
            }
        }


        pw.write("\r -------------------------------------------------------------------------------------------------------- \r\r");

    }

    public void writeRoundWinner(Player player, int i) {

        if (i == 0){
            pw.write("This Round is Draw ! \r");
        }
        else {
            pw.write(player.getName() + " Win this round! \r");
        }

        pw.write("\r -------------------------------------------------------------------------------------------------------- \r\r");

    }



    public void writeGameWinner(Player player) {

        pw.write("The winner of the game is: " + player.getName() + " !\r");

    }


    public void close() {
        pw.close();
    }

}
