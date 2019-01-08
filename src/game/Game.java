package game;

import java.util.ArrayList;

import arbitrator.Arbitrator;

public class Game {
	public static final int MAX_PLAYER = 4;
	public static final int MAX_DICE = 5;

	public static void main(String[] args) {
		ArrayList<String> lstPlayer = new ArrayList<String>();
		lstPlayer.add("Manh");
		//lstPlayer.add("Duc");
		//lstPlayer.add("Nam");
		//lstPlayer.add("Ngoc");
		Arbitrator arbitrator = new Arbitrator(lstPlayer);
		arbitrator.start();
	}
}
