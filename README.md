# batterymanagement
Battery Management
A Java Spring Boot application that provides RESTful APIs to allow users to insert a list of batteries and get the batteries in a range of postal code values

PreRequisites
 Java 11 or higher 
 Maven
 

Installation
1)Clone the repository to your local machine.
2)Open a terminal or command prompt and navigate to the project root directory.
3)you can then mvn clean test
4)Run mvn spring-boot:run to start the application.
5)Use Postman to make calls to the services 
6)Please add the batteries before performing get requests 

APIs
The following APIs are available:
/batteries : List all batteries (GET)
/add		: add a list of batteries 
/fetchBatteriesFromRange/?range=<yourvalue seperated by a '-'> : get batteries in range sorted by name and statistics are available 

