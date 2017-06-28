/**
 * File: Fleet.java
 * 
 * @version 1.1
 * 
 * @author Sanjay Haresh Khatwani (sxk6714)
 * @author Bhavin Sanjay Bhuta (bsb5375)
 * 
 *         This class builds Fleet by placing each types of ships.
 */

public class Fleet {
	private Ship carrier = new Carrier();
	private Ship battleship = new BattleShip();
	private Ship cruiser = new Cruiser();
	private Ship destroyer = new Destroyer();

	private BattleShipOcean ocean = new BattleShipOcean(10);

	/**
	 * This method builds Fleet by placing each types of ships.
	 * 
	 * @param: none
	 * @return: none
	 * 
	 */
	public void buildFleet() {
		carrier.placeShip(ocean.getOcean());
		carrier.addToOcean(ocean.getOcean());

		battleship.placeShip(ocean.getOcean());
		battleship.addToOcean(ocean.getOcean());

		cruiser.placeShip(ocean.getOcean());
		cruiser.addToOcean(ocean.getOcean());

		destroyer.placeShip(ocean.getOcean());
		destroyer.addToOcean(ocean.getOcean());
	}

	public Ship getCarrier() {
		return carrier;
	}

	public void setCarrier(Ship carrier) {
		this.carrier = carrier;
	}

	public Ship getBattleship() {
		return battleship;
	}

	public void setBattleship(Ship battleship) {
		this.battleship = battleship;
	}

	public Ship getCruiser() {
		return cruiser;
	}

	public void setCruiser(Ship cruiser) {
		this.cruiser = cruiser;
	}

	public Ship getDestroyer() {
		return destroyer;
	}

	public void setDestroyer(Ship destroyer) {
		this.destroyer = destroyer;
	}

	public Ocean getOcean() {
		return ocean;
	}

	public void setOcean(BattleShipOcean selfFleet) {
		this.ocean = selfFleet;
	}

}
