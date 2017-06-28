/**
 * File: BattleShipOcean.java
 * 
 * @version 1.1
 * 
 * @author Sanjay Haresh Khatwani (sxk6714)
 * @author Bhavin Sanjay Bhuta (bsb5375)
 * 
 *         This class extends the abstract class Ocean and defines implementation
 *         for the function defined in abstract Ocean class
 */
public class BattleShipOcean extends Ocean{
	
	protected String[][] ocean = new String[10][10];

	public String[][] getOcean() {
		return ocean;
	}

	public void setOcean(String[][] ocean) {
		this.ocean = ocean;
	}
	
	public BattleShipOcean(int size) {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				this.ocean[row][col] = Constants.WATER;
			}
		}
	}

	private int size = 10;
	
	/**
	 * This method prints the contents of the ocean.
	 * 
	 * @param: none
	 * @return: none
	 * 
	 */
	public void printOcean() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				System.out.print(ocean[row][col] + " ");
			}
			System.out.println();
		}
	}

}
