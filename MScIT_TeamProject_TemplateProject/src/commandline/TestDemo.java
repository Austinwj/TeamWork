package commandline;

public class TestDemo {
	public static void main(String[] args) {
		Card c1 = new Card("350r",1,9,2,3,0);
		System.out.println(c1.getName());
		c1.getProperty(0);
	}
}
