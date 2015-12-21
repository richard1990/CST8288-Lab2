/**
 * network is the package for class placement	
 */
package network;
// import statements
import javax.swing.JOptionPane;
/**
 * This class is a simulation of Shannon's Theorem. The user is asked to 
 * enter a bandwidth and signal-to-noise ratio, after which the program
 * will print the result.
 * @author		Richard Barney
 * @since 		1.7
 * @version		1.0.1 February 6, 2015
 */
public class ShannonsTheorem {
	/** ShannonsModel object. */
	private ShannonsModel model = new ShannonsModel();

	/**
	 * Default constructor
	 */
	public ShannonsTheorem() { }
	
	/**
	 * Get method that returns ShannonsModel.getBandwidth()
	 * @return	bandwidth	double containing the bandwidth.
	 */
	public double getBandwidth() { return model.getBandwidth(); }
	/**
	 * Get method that returns ShannonsModel.getSignalToNoise()
	 * @return signal-to-noise ratio as a double
	 */
	public double getSignalToNoise() { return model.getSignalToNoise(); }
	/**
	 * Get method that returns ShannonsModel.getMaximumDataRate()
	 * @return maximum data rate in bits per second as a double.
	 */
	public double getMaximumDataRate() { return model.getMaximumDataRate(); }
	
	/**
	 * 	 * Set method for bandwidth using ShannonsModel.setBandwidth.
	 * @param    bandwidth    double containing the bandwidth (hertz).
	 */
	public void setBandwidth(double bandwidth) { model.setBandwidth(bandwidth); }
	/**
	 * Set method for signal-to-noise ratio using ShannonsModel.setBandwidth.
	 * @param    signalToNoise   double containing the signal-to-noise ratio (decibels).
	 */
	public void setSignalToNoise(double signalToNoise) { model.setSignalToNoise(signalToNoise); }
	
	/**
	 * Entry point "main()" as required by the JVM.
	 * @param  args   Standard command line parameters (arguments) as a string array.
	 */
	public static void main (String args[]) {
		String sBandwidth; // String value to hold bandwidth for JOptionPane
		String sSignalToNoise; // String value to hold signal-to-noise ratio for JOptionPane
		String sLoop = "y"; // String used for asking user if they want to run program again
		boolean validationLoop; // boolean used to loop for data validation
		ShannonsTheorem shannonsTheorem = new ShannonsTheorem(); // ShannonsTheorem object
		JOptionPane.showMessageDialog(null, "Welcome to Richard Barney's Shannon's Theorem calculator!", "Welcome!", JOptionPane.PLAIN_MESSAGE);
		
		while (sLoop.toLowerCase().equals("y")) { // keep looping program as long as user enters 'y' when asked if they want to try again
			validationLoop = true; // set boolean to true for data validation
			do { // get bandwidth input, keep looping as long as validationLoop is true
				try {
					do {
						sBandwidth = JOptionPane.showInputDialog(null, "Please enter the bandwidth.", "Enter banwidth", JOptionPane.QUESTION_MESSAGE); // ask for hertz
						if (sBandwidth == null) { // if user clicks cancel, quit the program
							JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						}
						shannonsTheorem.setBandwidth(Double.parseDouble(sBandwidth));
					} while (Double.parseDouble(sBandwidth) <= 0);
					validationLoop = false; // stop looping for data validation if input is valid
				} catch (NumberFormatException e) { // catch invalid input
					JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number!", "Error encountered!", JOptionPane.ERROR_MESSAGE);
				}
			} while (validationLoop); // end get bandwidth input
			
			validationLoop = true; // set boolean to true again for second loop for data validation
			do { // get signal-to-noise ratio input, keep looping as long as validationLoop is true
				try {
					do {
						sSignalToNoise = JOptionPane.showInputDialog(null, "Please enter the signal-to-noise ratio.", "Enter signal-to-noise ratio", JOptionPane.QUESTION_MESSAGE); // ask for SNR
						if (sSignalToNoise == null) { // if user clicks cancel, quit the program
							JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						}
						shannonsTheorem.setSignalToNoise(Double.parseDouble(sSignalToNoise));
					} while (Double.parseDouble(sSignalToNoise) <= 0);
					validationLoop = false; // stop looping for data validation if input is valid
				} catch (NumberFormatException e) { // catch invalid input
					JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number!", "Error encountered!", JOptionPane.ERROR_MESSAGE);
				}	
			} while (validationLoop); // end get signal-to-noise ratio input
			
			// display results
			JOptionPane.showMessageDialog(null, "[After calculating Shannon's Theorem with a bandwidth of "
												+shannonsTheorem.getBandwidth()
											 	+" hertz and a\nsignal-to-noise ratio of "
											 	+shannonsTheorem.getSignalToNoise()
											 	+" decibels, the result is "
											 	+String.format("%.2f", shannonsTheorem.getMaximumDataRate())
											 	+" bits-per-second.]", "Result", JOptionPane.INFORMATION_MESSAGE);

			validationLoop = true; // set boolean to true again for third loop for data validation
			do { 
				try {
					do {  // ask user if they want to run program again, keep looping as long as validationLoop is true
						sLoop = JOptionPane.showInputDialog(null, "Do you want to try again?\nEnter 'y' for yes, 'n' for no.", "Again?", JOptionPane.QUESTION_MESSAGE);
						if (sLoop == null || (sLoop.toLowerCase().charAt(0) == 'n' && sLoop.length() == 1)) { // if user clicks cancel or enters 'n', quit the program
							JOptionPane.showMessageDialog(null, "Quiting program...\nGoodbye.", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						}
						validationLoop = false;
					} while (sLoop.toLowerCase().charAt(0) != 'y' || sLoop.length() > 1); // end asking user if they want to run program again
				} catch(StringIndexOutOfBoundsException | NullPointerException e) { // catching multiple exceptions with single catch statement, requires Java 1.7
					JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number!", "Error encountered!", JOptionPane.ERROR_MESSAGE);
				}
			} while (validationLoop); // end get signal-to-noise ratio input
		} // end big while loop to keep running program
	} // end method main
} // end class ShannonsTheorem