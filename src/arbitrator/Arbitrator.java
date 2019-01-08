package arbitrator;

import java.util.ArrayList;
import java.util.Random;

import dice.Dice1;
import dice.Dice2;
import dice.Dice3;
import dice.Dice4;
import dice.Dice5;
import dice.IDice;
import game.Game;
import player.AVirtualPlayer;
import player.Player;
import player.VirtualPlayer1;
import player.VirtualPlayer2;
import player.VirtualPlayer3;
import player.VirtualPlayer4;

public class Arbitrator {
	private ArrayList<Player> lstPlayer;
	private ArrayList<IDice> lstDice;
	private ArrayList<AVirtualPlayer> lstVirtualPlayer;
	private int turn;
	private boolean isGameOver;

	/**
	 * constructor Arbitrator
	 * 
	 * @param _lstPlayer : list name of the real player
	 */
	public Arbitrator(ArrayList<String> _lstPlayer) {
		// initialize Dice
		lstDice = new ArrayList<IDice>();
		lstDice.add(new Dice1());
		lstDice.add(new Dice2());
		lstDice.add(new Dice3());
		lstDice.add(new Dice4());
		lstDice.add(new Dice5());

		// initialize Virtual Player
		lstVirtualPlayer = new ArrayList<AVirtualPlayer>();
		lstVirtualPlayer.add(new VirtualPlayer1());
		lstVirtualPlayer.add(new VirtualPlayer2());
		lstVirtualPlayer.add(new VirtualPlayer3());
		lstVirtualPlayer.add(new VirtualPlayer4());

		// inititalize real Player
		lstPlayer = new ArrayList<Player>();
		for (String name : _lstPlayer) {
			lstPlayer.add(new Player(name));
		}

		// add Virtual Player if real Player < MAX_PLAYER
		if (lstPlayer.size() < Game.MAX_PLAYER) {
			int quantityVirtualPlayer = game.Game.MAX_PLAYER - lstPlayer.size();
			for (int i = 0; i < quantityVirtualPlayer; i++) {
				lstPlayer.add(lstVirtualPlayer.get(i));
			}
		}
	}

	public void start() {
		setOrder();
		turn = 0;
		isGameOver = false;
		while (!isGameOver) {
			nextPlayer();
		}
		gameOver();
	}

	private void setOrder() {

	}

	private void nextPlayer() {
		// base turn, calculate who is next player??
		if (turn >= Game.MAX_PLAYER) {
			turn = 0;
		}
		Player nextPlayer = lstPlayer.get(turn);

		// get Dice, drop and return results
		Random rand = new Random();
		int diceChose = rand.nextInt(Game.MAX_DICE);// function return Integer from 0 -> MAX_DICE
		int pointReceived = lstDice.get(diceChose).dropDice();// player drop Dice
		int newPoint = pointReceived + nextPlayer.getPoint();// calculate point for Player
		nextPlayer.setPoint(newPoint <= 21 ? newPoint : 0);// reset point for Player, if newPoint >21 return 0

		// Test game over
		if (nextPlayer.getPoint() == 21) {
			isGameOver = true;
			return;
		}

		turn++;
	}

	private void gameOver() {

		System.out.println("The winner is " + lstPlayer.get(turn).getName());

		for (int i = 0; i < 4; i++) {
			if (i != turn) {
				if (lstPlayer.get(i) instanceof AVirtualPlayer) {
					// dynamic byding
					AVirtualPlayer av = (AVirtualPlayer) lstPlayer.get(i);
					av.expressEmotion();
				}

			}
		}

		System.out.println("\n----------------------------------\nGame over");

	}
}
