/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import strategy.MallardDuck;
import strategy.Quackable;

/**
 * JUnit class to Test MallardDuck class
 * 
 * @author Leonardo
 */
class TestRedHeadDuck {

	@ParameterizedTest(name = "Stringa aspettata: {0} ")
	@CsvSource(value = {"Hi I am a MullardDuck"})
	void testaVersoAnatra(String ritornato) {
		Quackable mallardDuck = new MallardDuck();
		String returned = mallardDuck.quack();
		assertEquals(ritornato, returned);
	}
}
