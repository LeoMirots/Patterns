# Patterns
Demo repository to show an implementation of some useful object oriented programming patterns

This is an Eclipse standard java project: all source code located in "src" folder and all documentation can be found inside "doc" folder.
Folder "bin" contains .class binary files to run with Java Virtual Machine for debugging.
This software was written for Java version 1.8_212

Program to show some software design pattern combined together to solve
complex problems.

Let us suppose to have an enterprise that creates a simulation game based on "ducks"
we have some software behaviors to implement:
1) Duck can have different behaviors according with their models
	  E.g. Ducks can make "quack" if they are mallard or "squeack" if they are rubber-ducks
2) We would like to model also Geese
3) We want to study is the total number of quacks made by a flock of ducks.
    How can we add the ability to count duck quacks without having to change the duck classes? 
4) Why don’t we take the creation of ducks and localize  it in one place;
    We need some quality control to make sure our ducks get wrapped.
5) It’s getting a little difficult to manage all these different ducks separately.
  	Is there any way you can help us manage ducks as a whole, 
    and perhaps even allow us to manage a few duck “families” that we’d like to keep track of?

In this project I split each pattern inside a package to let you better understand wich class is really necessary for that pattern.
