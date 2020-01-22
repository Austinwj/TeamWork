package code1;
import java.io.PrintStream;
public class Person{
	public Person(String n, int d, int m, int y, int t)
	{
	name = n;
	dob_d = d;
	dob_m = m;
	dob_y = y;
	worker = null;
	nworkers = 0;
	type = t;
	}
	
	public void leader(Person b) 
	{
		boss = b;
		b.worker[b.nworkers++] = this;
	}
	
	
	public void print(PrintStream ps)
	{
		ps.print(String.format("%s: born on %02d/%02d/%4d", name, dob_d, dob_m,
		dob_y));
		if (type == 1)
		{
			ps.print(" bosses: ");
			for (int i = 0; i < nworkers; i++)
			ps.print(worker[i].name+" ");
		}
		else
			ps.print(" is bossed by "+boss.name);
		ps.print("\n");
	}
	private String name;
	private int dob_d, dob_m, dob_y, nworkers, type; // date of birth   1 = Boss, 2 = Worker
	private Person boss;
	public Person[] worker;
}
