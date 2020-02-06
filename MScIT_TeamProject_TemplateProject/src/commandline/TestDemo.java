package commandline;

public class TestDemo {
	public static void main(String[] args) {
		Card c1 = new Card("350r",1,9,2,3,0);
		Card c2 = new Card("Test2",1,2,3,4,5);
		System.out.println(c1.getName());
		c1.getProperty(0);
		Player p1 = new Player("Test");
		p1.addCard(c1);
		p1.addCard(c2);
		System.out.println(p1.peekAtTopCard().getName());
		System.out.println(p1.getDeck().getSizeofDeck());
	}
}
