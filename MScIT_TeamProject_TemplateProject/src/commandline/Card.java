package commandline;

public class Card {
	
	private String name;
	private String[] properties = {"Size", "Speed", "Range" , "Firepower", "Cargo"};
	private int[] values = new int[5];
	private int size, speed, range, firepower, cargo;
	
	public Card(String name, int size, int speed, int range, int firepower, int cargo){
		this.name = name;
		this.values[0] = size;
		this.values[1] = speed;
		this.values[2] = range;
		this.values[3] = firepower;
		this.values[4] = cargo;
	}

	public String getName() {
		return name;
	}

	public int getSize(){
		return this.values[0];
	}

	public int getSpeed(){
		return this.values[1];
	}

	public int getRange(){
		return this.values[2];
	}

	public int getFirepower(){
		return this.values[3];
	}

	public int getCargo(){
		return this.values[4];
	}

}
