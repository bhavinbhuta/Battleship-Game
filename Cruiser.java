import java.util.Scanner;

/**
 * File: Cruiser.java
 * 
 * @version 1.1
 * 
 * @author Sanjay Haresh Khatwani (sxk6714)
 * @author Bhavin Sanjay Bhuta (bsb5375)
 * 
 *         This class implements Ship interface, defines functions 
 *         defined in it and makes valdiation check for itself.
 */
public class Cruiser implements Ship {
	
	public static int length = 3;
	public static String name = "CRU";
	
	public int startX, endX, startY, endY;

	/**
	 * This method checks if a ship is destroyed.
	 * 
	 * @param: Ship
	 *             of type ship class
	 * @return: true or false
	 * 
	 */
	@Override
	public boolean isSunk(String[][] ocean) {
		for (int row = this.getStartX(); row <= this.getEndX(); row++) {
			for (int col = this.getStartY(); col <= this.getEndY(); col++) {
				if (!ocean[row][col].contains("X")) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method takes input of positions to place a ship and passes to
	 * validation method to check it's respective constraints.
	 * 
	 * @param: Ship
	 *             of type ship class
	 * @return: none
	 * 
	 */
	public void placeShip(String ocean[][]) {
		Scanner sysScanner = new Scanner(System.in);
		System.out.println("Enter the start and end positions of your : " + this.name);
			int x1 = sysScanner.nextInt();
			int y1 = sysScanner.nextInt();
			int x2 = sysScanner.nextInt();
			int y2 = sysScanner.nextInt();
		int validation = this.validateShip(x1, y1, x2, y2, ocean);
		if (validation == Constants.VALIDATION_PASS) {
			this.setStartX(x1);
			this.setStartY(y1);
			this.setEndX(x2);
			this.setEndY(y2);
		} else {
			if (validation == Constants.VALIDATION_POSITION_ERROR) {
				System.err.println("Ship is either touching the edge of ocean or another ship! Please re-enter");
			} else {
				if (validation == Constants.VALIDATION_ORIENTATION_ERROR) {
					System.err.println("Ship is placed diagonnaly, which is not allowed! Please re-enter");
				} else {
					System.err.println("Length of " + this.name + " should be "+this.getLength()+"! Please re-enter");
				}
			}
			this.placeShip(ocean);
		}

	}
	
	/**
	 * This method checks for whether the ship is touching the ocean or another
	 * ship the ships and acoordingly pass to the place ship method.
	 * 
	 * @param: x1
	 *             - starting x coordinate
	 * @param: y1
	 *             - starting y coordinate
	 * @param: x2
	 *             - ending x coordinate
	 * @param: y2
	 *             - ending x coordinate
	 * @param: Ship
	 *             - ship object of type ship
	 * @return: integer (0, 1, 2) - based on input recevied
	 * 
	 */
	private int validateShip(int x1, int y1, int x2, int y2, String ocean[][]) {
		if (this.validateOrientation(x1, x2, y1, y2)) {
			if (this.validateLength(x1, y1, x2, y2)) {
				if (this.validatePosition(x1, y1, x2, y2, ocean)) {
					return Constants.VALIDATION_PASS;
				} else {
					return Constants.VALIDATION_POSITION_ERROR;
				}
			} else {
				return Constants.VALIDATION_LENGTH_ERROR;
			}
		} else {
			return Constants.VALIDATION_ORIENTATION_ERROR;
		}

	}
	
	/**
	 * This method checks for the orienatation of the ship so as to cater with
	 * diagonal placement of ship
	 * 
	 * @param: x1
	 *             - starting x coordinate
	 * @param: y1
	 *             - starting y coordinate
	 * @param: x2
	 *             - ending x coordinate
	 * @param: y2
	 *             - ending y coordinate
	 * @return: true or false.
	 */
	private boolean validateOrientation(int x1, int x2, int y1, int y2) {
		if (x1 == x2 || y1 == y2) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks for whether the ship or doesn't allow the ship to be
	 * of greater based on the pre-defined length of the ships and accordingly
	 * take action
	 * 
	 * @param: x1
	 *             - starting x coordinate
	 * @param: y1
	 *             - starting y coordinate
	 * @param: x2
	 *             - ending x coordinate
	 * @param: y2
	 *             - ending x coordinate
	 * @param: Ship
	 *             - ship object of type ship
	 * @return: true or false.
	 */
	public boolean validateLength(int x1, int y1, int x2, int y2) {
		int length, requiredLength = 0;
		if (y1 == y2) {
			length = x2 - x1 + 1;
		} else {
			length = y2 - y1 + 1;
		}

		if (length != this.getLength())
			return false;
		else
			return true;
	}

	/**
	 * This method checks if a ship is touching any other ship or the edge of
	 * ocean
	 * 
	 * @param: x1
	 *             - starting x coordinate
	 * @param: y1
	 *             - starting y coordinate
	 * @param: x2
	 *             - ending x coordinate
	 * @param: y2
	 *             - ending x coordinate
	 * @param: Ship
	 *             - ship object of type ship
	 * @return: true or false.
	 */
	public boolean validatePosition(int x1, int y1, int x2, int y2, String ocean[][]) {

		if (y1 == y2) {
			for (int xIndex = x1 - 1; xIndex <= x2 + 1 && xIndex < ocean.length; xIndex++) {
				if (!ocean[xIndex][y1 - 1].equalsIgnoreCase(Constants.WATER)) {
					return false;
				}
				if (!ocean[xIndex][y1].equalsIgnoreCase(Constants.WATER)) {
					return false;
				}
				if (!ocean[xIndex][y1 + 1].equalsIgnoreCase(Constants.WATER)) {
					return false;
				}
			}
		} else {
			for (int yIndex = y1 - 1; yIndex <= y2 + 1; yIndex++) {
				if (!ocean[x1 - 1][yIndex].equalsIgnoreCase(Constants.WATER)) {
					return false;
				}
				if (!ocean[x1][yIndex].equalsIgnoreCase(Constants.WATER)) {
					return false;
				}
				if (!ocean[x1 + 1][yIndex].equalsIgnoreCase(Constants.WATER)) {
					return false;
				}
			}
		}

		return true;
	}
	
	/**
	 * This method places the ship in particular players ocean
	 * 
	 * @param: ship
	 *             variable of type Ship class
	 * @return: none
	 * 
	 */
	public void addToOcean(String ocean[][]) {
		if (this.getStartY() == this.getEndY()) {
			for (int xindex = this.getStartX(); xindex <= this.getEndX(); xindex++) {
				ocean[xindex][this.getStartY()] = this.name;
			}
		} else {
			for (int yindex = this.getStartY(); yindex <= this.getEndY(); yindex++) {
				ocean[this.getStartX()][yindex] = this.name;
			}
		}
	}

	public static int getLength() {
		return length;
	}

	public static void setLength(int length) {
		Cruiser.length = length;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}
	
	
}
