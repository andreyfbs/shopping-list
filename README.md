# Shopping List

## Some Technologies

* Java
* Jetty
* Gradle
* Spring // Spring Boot
* Cucumber
* Sonar
* H2

## Run the Application

It's a Spring Boot Application, so it's so easy to execute.

2 ways:

1. Jar in command line

java -jar sl-api.jar

2. IDE

Run the class SlApiApplication

## Access the Application

The default port is 8090 (check application.properties):
 
URL: http://localhost:8090/health

## Implemented Endpoint

I chose the EndPoint of List's Creation.

### Design
Method: [POST]  
URL: /shopping-list

+ Request (application/json)

+ Headers
X-Token-Session: <STRING>
X-Account-device-id": <LONG>

+ Body
{
"list-id-device": <LONG>,
"list-name": <STRING>,
"items": [{
    "item-id-device": <LONG>,
    "item-name": <STRING>,
    "is-checked": <BOOLEAN>,
    "quantity-description": <STRING>
    }, {
    "item-id-device": <LONG>,
    "item-name": <STRING>,
    "is-checked": <BOOLEAN>,
    "quantity-description": <STRING>
}]
}

+ Response 201 (application/json)
+ Body
{
"list-id-server": <LONG>
"items": [{
    "item-id-device": <LONG>,
    "item-id-server": <LONG>
    }, {
    "item-id-device": <LONG>,
    "item-id-server": <LONG>
}]
}

## Api Documentation

I used Swagger. One nice thing about it, I can build the documentation using Bottom-up approach, or code first. Another, that is interactive.

For tests in the application, check:

http://localhost:8090/swagger-ui.html

## Tests

I've been building Microservices for 2 years. In my projects I realized that the Components tests are one of more effective. Of course, some others Tests are important as well, as Units Tests. For this project I created a basic sample structure to BDD Tests with Cucumber.

This is a interesting article about Microservices Testing:

https://martinfowler.com/articles/microservice-testing/

### Component Tests

Run the class TestCucumberSuiteRunner to see the execution of the tests.

## SonarQube

I used in this project. Sonar is tool for continuous inspection of code. It's very important to check the quality of the software. You can also check the test coverage.
 
To run:

./gradlew clean sonarqube

It's very easy to use a sample. You only need to download a Docker image:

Execute: docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube

I put in the folder Sonar some inspection examples of this Application.