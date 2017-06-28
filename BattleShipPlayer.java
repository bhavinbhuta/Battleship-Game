
public class BattleShipPlayer extends Player{

	/**
	 * This method returns true or false depending on whether all the ships are
	 * destroyed.
	 * 
	 * @param: none
	 * @return: true or false
	 * 
	 */
	public boolean isDefeated() {
		if (this.fleet.getCarrier().isSunk(ourOcean) && this.fleet.getBattleship().isSunk(ourOcean)
				&&this.fleet.getCruiser().isSunk(ourOcean) && this.fleet.getDestroyer().isSunk(ourOcean))
			return true;
		else
			return false;
	}

}
