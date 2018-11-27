To run the program:

Open a new terminal window and clone the repository:
	
	git clone https://github.com/jennyferpinto/triangle.git
	
To compile the program and run the unit tests, enter the following command in the terminal (the unit tests in place should all pass):

	mvn clean package 

To run the program from the jar file, enter the following command in the terminal:

	java -cp target/triangle-1.0-SNAPSHOT.jar triangle.Triangle

The program should run and produce the following prompt: 
	
	Enter 3 numbers representing a triangle's dimensions: 

Once 3 numbers are entered a response similar to the one below should display:
	
	[4, 5, 6]
	equilateral = false, isosceles = false, scalene = true


Design Considerations:

1. Chose to use Maven to easily build the java project and run unit tests
2. Checked if values passed to the Triangle constructor can build a legal triangle with the user entered values, if not an exception is raised
3. Decided to enter the chosen dimensions in an Array, so they can be retrieved if additional calculations are to be made with these dimensions
4. Created 3 separate methods to check for each Triangle type, for modularity purposes
5. Saved results of checking for a Triangle type in private class fields with public getters so they can be retrieved, if needed, rather than recalculated