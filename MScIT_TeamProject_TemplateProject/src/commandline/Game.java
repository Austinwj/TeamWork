package commandline;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Card> cardList = new ArrayList<Card>();
    private int num;
    private Player p1;


    public void play(){

        // Add cards to card list
        cardList.add(new Card("350r",1,9,2,3,0));
        cardList.add(new Card("Test2",1,2,3,4,5));
        cardList.add(new Card("Test3",1,3,5,1,2));
        cardList.add(new Card("Test4",4,5,7,2,1));
        cardList.add(new Card("Test5",1,7,3,8,3));

        Scanner sc = new Scanner(System.in);

        // First part of Game : Enter Name, Add Ai players
        System.out.println("-------Game Start-------");
        System.out.println("Enter your name:");
        String str = sc.nextLine();
        this.p1 = new Player(str);
        createDeck(p1);
        System.out.println("Enter number of AI players:");
        this.num = sc.nextInt();
        addAI(num);
        System.out.println("Game Start! You are player 1 and your name is: " + p1.getName() + ". Try to defeat " + num + " AI players!");

        // Second part of Game: Show result, draw cards
        showCard();


    }


    // Add AI players, depend on num input
    private void addAI(int num){
        for (int i = 0; i < num ; i++){
            String str = "AI Player " + (i + 1);
            players.add(new Player(str));
            createDeck(players.get(i));
        }
    }


    // Create deck for player
    private void createDeck(Player p){
        for (int i = 0; i < cardList.size() ; i++){
            p.addCard(cardList.get(i));
            p.getDeck().shuffle();
        }
    }


    private void showCard(){
        System.out.println(p1.getName() + ": " + p1.getDeck().peekAtTopCard().getName());
        for (int i = 0; i < num ; i++){
            System.out.println(players.get(i).getName() + ": " + players.get(i).getDeck().peekAtTopCard().getName());
        }
    }

}
