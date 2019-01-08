package player;

public class Player {
	private int point;
	protected String name;
	
	public Player() {};
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPoint() {
		return this.point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
}
