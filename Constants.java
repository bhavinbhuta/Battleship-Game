/**
 * File: Constants.java
 * 
 * @version 1.0
 * 
 * @author Sanjay Haresh Khatwani (sxk6714)
 * @author Bhavin Sanjay Bhuta (bsb5375)
 * 
 *         This class basically defines final variables for all the different
 *         elements of the battleship game. The values of these variables can't
 *         be modified.
 */
public class Constants {

	public static final String WATER = "H20";
	public static final String CARRIER = "CAR";
	public static final String BATTLESHIP = "BAS";
	public static final String CRUISER = "CRU";
	public static final String DESTROYER = "DES";

	public static final int CARRIER_LENGTH = 5;
	public static final int BATTLESHIP_LENGTH = 4;
	public static final int CRUISER_LENGTH = 3;
	public static final int DESTROYER_LENGTH = 2;

	public static final int VALIDATION_POSITION_ERROR = 0;
	public static final int VALIDATION_PASS = 1;
	public static final int VALIDATION_LENGTH_ERROR = 2;
	public static final int VALIDATION_ORIENTATION_ERROR = 3;

}
