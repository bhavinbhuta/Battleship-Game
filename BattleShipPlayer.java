/**
 * File: BattleShipPlayer.java
 * 
 * @version 1.1
 * 
 * @author Sanjay Haresh Khatwani (sxk6714)
 * @author Bhavin Sanjay Bhuta (bsb5375)
 * 
 *         This class extends the abstract class Player and defines implementation
 *         for the function defined in Player abstract class
 */
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
