/**
 * 
 */
package factory;

import decorator.QuackCounter;
import strategy.MallardDuck;
import strategy.PheasantCall;
import strategy.Quackable;
import strategy.RedHeadDuck;

/**
 * Concrete factory class to construct all Ducks objects
 * Each method wraps the Quackable with the quack counting decorator. 
 * 
 * @author Leonardo
 */
public class DuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		// TODO Auto-generated method stub
		return new QuackCounter(new MallardDuck());
	}

	@Override
	public Quackable createRedheadDuck() {
		// TODO Auto-generated method stub
		return new QuackCounter(new RedHeadDuck());
	}

	@Override
	public Quackable createPheasantCall() {
		// TODO Auto-generated method stub
		return new QuackCounter(new PheasantCall());
	}
	
}
