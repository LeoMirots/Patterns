/**
 * 
 */
package decorator;

import strategy.Quackable;

/**
 * Class to wrap a Quackable object to count all the quacks;
 * 
 * @author Leonardo
 */
public class QuackCounter implements Quackable {
	/**
	 * Target object to wrap
	 */
	Quackable duck;
	/**
	 * This variable is static only for comfort
	 */
	static int quacksNumber;
	
	
	/**
	 * Constructor to obtain the basic existing element to wrap
	 * 
	 * @param duck the duck to wrap with our decorator
	 */
	public QuackCounter(Quackable duck) {
		super();
		this.duck = duck;
	}
	
	/**
	 * Static getter function
	 * 
	 * @return Total number of quacks reached;
	 */
	public static int getQuacks() {
		return quacksNumber;
	}


	/**
	 *	Overriding (forced by the interface) this method adding some actions before returning the same
	 *	value of the original not wrapped duck object
	 */
	@Override
	public String quack() {
		// TODO Auto-generated method stub
		++quacksNumber;
		return duck.quack();
	}	
}
