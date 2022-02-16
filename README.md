# flightDataApp
An app that provides live data of all aircrafts over a geographical region

Hello team

Thank you for the opportunity to work on this interesting project
I have worked on it for a total of 2 hours. I wish I could dedicate more time but I could only work for short time due to previous work commitments

#endoints implemented

I have implemented the following 3 endpoints along with integration tests to validate them:

GET /flightState : Get live flight state data at the time of request

PUT /addRegion : Define a new region to track flights over the region

GET /flightsOverRegion/{regionName} : Get total flights over region. A flight is identified by a composite key consisting of icao24 address and callSign

Next steps (Not done but should be done given more time than 2 hours):
1) Refactoring integration tests : Currently there is only 1 test method that includes multiple tests. This needs to be refactored into test represting specific test scenarios
2) More Unit tests for service class
3) Unit tests to validate logic in Service class
4) API integration tests (Using framework like RestAssured)
5) Performance tests (Using a framework like Gatling)
