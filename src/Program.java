import adapter.Goose;
import adapter.GooseAdapter;
import composite.Flock;
import decorator.QuackCounter;
import factory.DuckFactory;
import strategy.MallardDuck;
import strategy.PheasantCall;
import strategy.Quackable;
import strategy.RedHeadDuck;

/**
 * Program to show some software design pattern combined together to solve
 * complex problems.
 * 
 *  Let us suppose to have an enterprise that creates a simulation game based on "ducks"
 *  we have some software behaviors to implement:
 *  
 *  1) Duck can have different behaviors according with their models
 *  	E.g. Ducks can make "quack" if they are mallard or "squeack" if they are rubber-ducks
 *  
 *  2) We would like to model also Geese
 *  
 *  3) We want to study is the total number of quacks made by a flock of ducks.
 *  	How can we add the ability to count duck quacks without having to change the duck classes?
 *  
 *  4) Why don’t we take the creation of ducks and localize  it in one place;
 *  	We need some quality control to make sure our ducks get wrapped.
 *  
 *  5) It’s getting a little difficult to manage all these different ducks separately.
 *  	Is there any way you can help us manage ducks as a whole, 
 *  	and perhaps even allow us to manage a few duck “families” that we’d like to keep track of?
 */

/**
 * Class to test our software
 * 
 * @author Leonardo
 */
public class Program {

	/**
	 * Demo Entry-point
	 * 
	 * @param args useless
	 */
	public static void main(String[] args) {
		//To solve problem 1 we can use a Strategy pattern
		Program duckSimulator = new Program();
		duckSimulator.simulate();
		
		//To solve problem 2 we can use an Adapter pattern
		duckSimulator.simulate_with_goose();
		
		//To solve problem 3 we can use a Decorator pattern
		duckSimulator.simulate_with_counter();
		
		//To solve problem 4 we can use a Factory pattern
		duckSimulator.simulate_with_factory();
		
		//To solve problem 5 we can use a Composite pattern
		duckSimulator.simulate_with_composite();
		
	}


	/**
	 * Method to test Strategy patterns
	 */
	protected void simulate() {
		Quackable mallardDuck = new MallardDuck(); 	//Verso dell'anatra selvatica
		Quackable redHeadDuck = new RedHeadDuck(); 	//Verso della papera dalla testa rossa
		Quackable pheasantCall = new PheasantCall(); 	//Verso del fagiano
		
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		System.out.println("\nStarting Duck simulator...\n");
			makeSound(mallardDuck);
			makeSound(redHeadDuck);
			makeSound(pheasantCall);
			
			makeSound(gooseDuck);
		System.out.println("\nEnding Duck simulator...\n");
	}
	private void makeSound(Quackable duck) {
		System.out.println(duck.quack());
	}
	
	
	/**
	 * Method to test Adapter pattern
	 */
	protected void simulate_with_goose() {
		Quackable mallardDuck = new MallardDuck(); 	//Verso dell'anatra selvatica
		Quackable redHeadDuck = new RedHeadDuck(); 	//Verso della papera dalla testa rossa
		Quackable pheasantCall = new PheasantCall(); 	//Verso del fagiano
		
		Quackable gooseDuck = new GooseAdapter(new Goose());	//Verso dell'oca
		
		System.out.println("\nStarting Duck and Goose simulator...\n");
			makeSound(mallardDuck);
			makeSound(redHeadDuck);
			makeSound(pheasantCall);
			
			makeSound(gooseDuck);
		System.out.println("\nEnding Duck and Goose simulator...\n");
	}
	
	/**
	 * Method to test Decorator pattern
	 */
	protected void simulate_with_counter() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck()); 	//Verso dell'anatra selvatica
		Quackable redHeadDuck = new QuackCounter(new RedHeadDuck()); 	//Verso della papera dalla testa rossa
		Quackable pheasantCall = new QuackCounter(new PheasantCall()); 	//Verso del fagiano
		
		Quackable gooseDuck = new QuackCounter(new GooseAdapter(new Goose()));	//Verso dell'oca
		/*
		 * IMPORTANT: the problem with wrapping objects: you have to make sure they get wrapped or they don’t get the decorated behavior.
		 */
		
		System.out.println("\nStarting Duck and Goose counter simulator...\n");
			makeSound(mallardDuck);
			makeSound(redHeadDuck);
			makeSound(pheasantCall);
			
			makeSound(gooseDuck);
			System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times\n");
		System.out.println("\nEnding Duck and Goose counter simulator...\n");
	}
	
	/**
	 * Method to test Factory pattern
	 */
	protected void simulate_with_factory() {
		//Instance a DuckFactory
		DuckFactory factory = new DuckFactory();
		
		Quackable mallardDuck = factory.createMallardDuck();			//it's equal to [new QuackCounter(new MallardDuck())]; 	//Verso dell'anatra selvatica
		Quackable redHeadDuck = factory.createRedheadDuck(); 			//it's equal to [new QuackCounter(new RedHeadDuck))];	//Verso della papera dalla testa rossa
		Quackable pheasantCall = factory.createPheasantCall(); 			//it's equal to [new QuackCounter(new PheasantCall))];	//Verso del fagiano
		
		//The simulator will never know the difference; it just gets back a Quackable. 
		
		Quackable gooseDuck = new GooseAdapter(new Goose());	//Verso dell'oca
		/*
		 * IMPORTANT: the problem with wrapping objects: you have to make sure they get wrapped or they don’t get the decorated behavior.
		 * In this case it's right because we won't count "honk" of geese but only quack of ducks;
		 */
		
		System.out.println("\nStarting Duck and Goose factory simulator...\n");
			makeSound(mallardDuck);
			makeSound(redHeadDuck);
			makeSound(pheasantCall);
			
			makeSound(gooseDuck);
			System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times\n");
		System.out.println("\nEnding Duck and Goose factory simulator...\n");
	}
	
	/**
	 * Method to test Composite pattern
	 */
	protected void simulate_with_composite() {
		//Instance a DuckFactory
		DuckFactory factory = new DuckFactory();
		
		Quackable mallardDuck = factory.createMallardDuck();			//it's equal to [new QuackCounter(new MallardDuck())]; 	//Verso dell'anatra selvatica
		Quackable redHeadDuck = factory.createRedheadDuck(); 			//it's equal to [new QuackCounter(new RedHeadDuck))];	//Verso della papera dalla testa rossa
		Quackable pheasantCall = factory.createPheasantCall(); 			//it's equal to [new QuackCounter(new PheasantCall))];	//Verso del fagiano
		
		//The simulator will never know the difference; it just gets back a Quackable. 
		
		Quackable gooseDuck = new GooseAdapter(new Goose());	//Verso dell'oca
		/*
		 * IMPORTANT: the problem with wrapping objects: you have to make sure they get wrapped or they don’t get the decorated behavior.
		 * In this case it's right because we won't count "honk" of geese but only quack of ducks;
		 */
		
		/*
		 * IMPORTANT: We don't have to alter code: we just add flocks
		 */
		Flock ducksFlock = new Flock();
		ducksFlock.add(mallardDuck);
		ducksFlock.add(redHeadDuck);
		ducksFlock.add(pheasantCall);
		
		
		System.out.println("\nStarting Duck and Goose composite simulator...\n");
			/* Removing...
			 * makeSound(mallardDuck);
			 * makeSound(redHeadDuck);
			 * makeSound(pheasantCall);
			*/
			makeSound(ducksFlock);
			 
			
			makeSound(gooseDuck);
			System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times\n");
		System.out.println("\nEnding Duck and Goose composite simulator...\n");
	}
}
