
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
