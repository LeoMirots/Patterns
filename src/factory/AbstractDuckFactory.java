/**
 * 
 */
package factory;

import strategy.Quackable;

/**
 * The factory  should produce a family of products that consists of different types of ducks, 
 * so we’re going to use the Abstract Factory Pattern.
 * This class tells us wich object must be able to construct our DuckFactory
 * 
 * @author Leonardo
 */
public abstract class AbstractDuckFactory {
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createPheasantCall();
}
