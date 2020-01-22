package code1;
public class Main1{
	private static Person w1,w2,w3,b1,b2;
	
	public static void main(String[] args)
	{
	 w1 = new Person("aaa", 1, 2, 1991, 2); 
	 w2 = new Person("bbb", 3, 4, 1993, 2); 
	 w3 = new Person("ccc", 5, 6, 1995, 2); 
	 
	 b1 = new Person("ddd", 7, 8, 1997, 1); 
	 b1.worker = new Person[10];
	 b2 = new Person("eee", 9, 10, 1999, 1);
	 b2.worker = new Person[10];
	 
	 w1.leader(b1); 
	 w2.leader(b1); 
	 w3.leader(b1);
	 
	 b1.print(System.err); 
	 b2.print(System.err); 
	 w1.print(System.err); 
	 w2.print(System.err); 
	 w3.print(System.err); 
	}
}
