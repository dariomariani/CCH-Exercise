# CCH-Exercise

This repository contains the implementation of the three exercise provided by CCH Tagetik for going forward in 
the selection process.

Once cloned the repository, run mvn compile. Java 17 has been used.

If you open the project with IntelliJ you should have three test configuration:

* Exercise1Test which should run unit test for exercise 1
* ProductTest should run unit test for Product class
* Exercise2Test should run unit test for exercis 2

If you can't see the test configurations, run mvn test

Then there is a run configuration for exercise 3, Exercise3Application which run a Sprinboot app.
I had no time to implement automated tests for the sprinboot part.
Once Exercise3 is started you can use the following addresses to check data manually:
* http://localhost:8080/swagger-ui/index.html Swagger Interface to test API endpoints. Choose the endpoint you need to test and press try it now.
* http://localhost:8080/h2-console to check h2 database data, user sa pwd password
