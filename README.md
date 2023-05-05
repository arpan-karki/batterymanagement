# batterymanagement
Battery Management<br />
A Java Spring Boot application that provides RESTful APIs to allow users to insert a list of batteries and get the batteries in a range of postal code values<br />

PreRequisites<br />
 Java 11 or higher <br />
 Maven<br />
 <br />
<br />
Installation<br />
1)Clone the repository to your local machine. <br />
2)Open a terminal or command prompt and navigate to the project root directory.<br />
3)you can then mvn clean test<br />
4)Run mvn spring-boot:run to start the application.<br />
5)Use Postman to make calls to the services <br />
6)Please add the batteries before performing get requests <br />

APIs<br />
The following APIs are available:<br />
/batteries : List all batteries (GET)<br />
/add		: add a list of batteries <br />
/fetchBatteriesFromRange/?range=<yourvalue seperated by a '-'> : get batteries in range sorted by name and statistics are available <br />

