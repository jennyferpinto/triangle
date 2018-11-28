To run the program

Open a new terminal window and clone the repository:
	
	git clone https://github.com/jennyferpinto/triangle.git
	
To compile the program and run the unit tests, enter the following command in the terminal (the unit tests in place should all pass):

	mvn clean package 

To run the program from the jar file, enter the following command in the terminal:

	java -cp target/triangle-1.0-SNAPSHOT.jar triangle.Triangle

The program should run and produce the following prompt: 
	
	Enter 3 integers representing a triangle's dimensions: 

Once 3 integers are entered a response similar to the one below should display:
	
	[4, 5, 6]
	equilateral = false, isosceles = false, scalene = true


Design Considerations:

- Chose to use Maven to easily build the java project and run tests.

- Checked to see if values passed to the Triangle constructor built a legal triangle with user entered values. If not, an exception is raised.

- Decided to save a Triangle's dimensions in a private Array, with corresponding getters and setters, so that dimensions could be retrieved/modified and additional calculations could be made with these dimensions.

- Created 3 separate, for modularity purposes, methods, (isIsosceles, isScalene, isEquilateral) to check for each Triangle type. Additional considerations in the design of these Triangle type methods can be found in code comments within each method.

- Called these 3 Triangle type check methods during object instantation so that results from these checks could be saved to the Triangle object's private fields. Which are accessible and modifiable due to corresponding getters and setters.

- Created junit test suite to ensure correctness of Triangle methods.