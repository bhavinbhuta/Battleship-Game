
/**
 * File: TheGame.java
 * 
 * @version 1.0
 * 
 * @author Sanjay Haresh Khatwani (sxk6714)
 * @author Bhavin Sanjay Bhuta (bsb5375)
 * 
 * 		This file contains a main method and controls the execution
 * 		it takes users input to shoot, checks if it is a valid point 
 * 		and acoordingly takes actions
 */
import java.util.Scanner;

public class TheGame {

	private static Player player1 = new BattleShipPlayer();
	private static Player player2 = new BattleShipPlayer();

	/**
	 * The main method.
	 * 
	 * @param args
	 *            - ignored
	 */
	public static void main(String[] args) {

		setUpPlayers();
		play();
		declareResults();

	}

	/**
	 * This method builds up the fleets for 2 players taking user input
	 * 
	 * @param: none
	 * @return: none
	 * 
	 */
	public static void setUpPlayers() {
		Scanner sysScanner = new Scanner(System.in);
		System.out.println("Enter a name for Player 1:");
		player1.setPlayerName(sysScanner.nextLine());
		System.out.println("Enter a name for Player 2:");
		player2.setPlayerName(sysScanner.nextLine());

		System.out.println("Welcome " + player1.getPlayerName() + " and " + player2.getPlayerName() + " !");

		System.out.println("Let's build your Fleets!");
		System.out.println(player1.getPlayerName() + "'s turn");
		player1.getFleet().buildFleet();
		System.out.println(
				player1.getPlayerName() + "'s Fleet is ready. Now it's " + player2.getPlayerName() + "'s turn");
		player2.getFleet().buildFleet();

		System.out.println("Now that the fleets are ready, Let's battle !!");
	}

	/**
	 * This method imitates the turns of 2 players until somebody loses
	 * 
	 * @param: none
	 * @return: none
	 * 
	 */
	public static void play() {

		boolean keepPlaying = true;

		int[] shootPoints;

		while (keepPlaying) {

			shootPoints = getAndValidateShoot();
			assessHitOrMiss(shootPoints);

			Player swap = player1;
			player1 = player2;
			player2 = swap;

			keepPlaying = !player1.isDefeated() && !player2.isDefeated();
		}
	}

	/**
	 * This method checks if a shot hit a ship or no.
	 * 
	 * @param: shootPoints
	 *             - the coordinates to shoot
	 * @return: none
	 * 
	 */
	private static void assessHitOrMiss(int[] shootPoints) {

		if (!player2.getFleet().getOcean().getOcean()[shootPoints[0]][shootPoints[1]]
				.equalsIgnoreCase(Constants.WATER)) {
			String p2ShipType = player2.getFleet().getOcean().getOcean()[shootPoints[0]][shootPoints[1]];
			System.out.println("You HIT opponent's " + p2ShipType);
			player2.getFleet().getOcean().getOcean()[shootPoints[0]][shootPoints[1]] = p2ShipType.substring(0, 2) + 'X';
			player1.getOpponentShoots().getOcean()[shootPoints[0]][shootPoints[1]] = "H";
			System.out.println(player2.getPlayerName() + ", Your " + p2ShipType + " has been hit by "
					+ player1.getPlayerName() + ". Here's how your fleet looks like:");
			player2.getFleet().getOcean().printOcean();
		} else {
			System.out.println("Oh it's a miss!");
			player1.getOpponentShoots().getOcean()[shootPoints[0]][shootPoints[1]] = "M";
		}

	}

	/**
	 * This method declares result of the game.
	 * 
	 * @param: none
	 * @return: none
	 * 
	 */
	public static void declareResults() {
		if (player1.isDefeated()) {
			System.out.println(player1.getPlayerName() + " WON !!!");

		}
		if (player2.isDefeated()) {
			System.out.println(player2.getPlayerName() + " WON !!!");

		}
	}
	
	/**
	 * This method declares takes positions to shot and checks if it was shot
	 * at correct position.
	 * 
	 * @param: none
	 * @return: shootPoints
	 * 				- shooting coordinates
	 * 
	 */
	public static int[] getAndValidateShoot() {

		int shootPointX, shootPointY;
		Scanner sysScanner = new Scanner(System.in);
		System.out.println(player1.getPlayerName() + "'s turn:");
		System.out.println("Enter co-ordinates of points you want to shoot on " + player2.getPlayerName() + "'s ocean");
		shootPointX = sysScanner.nextInt();
		shootPointY = sysScanner.nextInt();

		if (!player1.getOpponentShoots().getOcean()[shootPointX][shootPointY].equalsIgnoreCase(Constants.WATER)) {
			System.err.println("You have already shot at this location before, Please choose any other location:");
			return getAndValidateShoot();
		} else {
			int[] shootPoints = { shootPointX, shootPointY };
			return shootPoints;
		}

	}

}
