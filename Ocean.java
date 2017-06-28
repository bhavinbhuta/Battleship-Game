/**
 * File: Ocean.java
 * 
 * @version 1.0
 * 
 * @author Sanjay Haresh Khatwani (sxk6714)
 * @author Bhavin Sanjay Bhuta (bsb5375)
 * 
 *         This file initiaises the ocean, prints the ocean and adds ship
 *         according to it's orientation.
 * 
 */
public abstract class Ocean {

	protected String[][] ocean;

	public String[][] getOcean() {
		return ocean;
	}

	public void setOcean(String[][] ocean) {
		this.ocean = ocean;
	}

	/**
	 * This method prints the contents of the ocean.
	 * 
	 * @param: none
	 * @return: none
	 * 
	 */
	public abstract void printOcean();
}
