
import java.util.Scanner;

public abstract class Player {

	private String playerName;
	private Ocean opponentShoots = new BattleShipOcean(10);
	protected Fleet fleet = new Fleet();
	protected String[][] ourOcean = this.fleet.getOcean().getOcean();
	
	
	
	/**
	 * This method returns true or false depending on whether all the ships are
	 * destroyed.
	 * 
	 * @param: none
	 * @return: true or false
	 * 
	 */
	public abstract boolean isDefeated();

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Ocean getOpponentShoots() {
		return opponentShoots;
	}

	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public void setOpponentShoots(Ocean opponentHits) {
		this.opponentShoots = opponentHits;
	}
}
