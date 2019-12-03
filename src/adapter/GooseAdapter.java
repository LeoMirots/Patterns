/**
 * 
 */
package adapter;

import strategy.Quackable;

/**
 * Class to manage a goose like a duck calling method quack
 * 
 * @author Leonardo
 */
public class GooseAdapter implements Quackable {
	Goose goose;
	
	
	/**
	 * Constructor to enable an adapter for a specific goose
	 * 
	 * @param goose goose to adapt
	 */
	public GooseAdapter(Goose goose) {
		super();
		this.goose = goose;
	}


	/**
	 * Core method to adapt honk method call to quack method call.
	 * When quack is called, the call is delegated to the goose’s honk() method.
	 */
	@Override
	public String quack() {
		// TODO Auto-generated method stub
		return goose.honk();
	}
}
