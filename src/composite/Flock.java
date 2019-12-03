/**
 * 
 */
package composite;

import java.util.ArrayList;
import java.util.Iterator;

import strategy.Quackable;

/**
 * Concrete class to implement the composite pattern.
 * It is basically a collection of objects all manageble in the same way, with the same methods
 * 
 * @author Leonardo
 */
public class Flock implements Quackable {
	ArrayList<Quackable> quackers = new ArrayList<Quackable>();
	
	/**
	 * Method to add an element to the whole of objects
	 * 
	 * @param quacker the object to add to the collection
	 */
	public void add(Quackable quacker) {
		this.quackers.add(quacker);
	}
	
	
	/**
	 * This methods operates with all the items of the collection
	 */
	@Override
	public String quack() {
		Iterator<Quackable> iterator = quackers.iterator();
		StringBuffer output = new StringBuffer();
		while (iterator.hasNext()) {
			Quackable quackerTmp = iterator.next();
			output.append(quackerTmp.quack());
			if (iterator.hasNext())
				output.append("\n");
	}
		return output.toString();
	}

}
