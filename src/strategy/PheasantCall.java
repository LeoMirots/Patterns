/**
 * 
 */
package strategy;

/**
 * Concrete Duck class to implement a specific behavior of quack method
 * 
 * @author Leonardo
 */
public class PheasantCall implements Quackable {

	/**
	 *Method to simulate animal call of this duck.
	 *I'm forced to implement this method by Quackable interface.
	 */
	@Override
	public String quack() {
		return "Hi I am a pheasant!";
	}
}

