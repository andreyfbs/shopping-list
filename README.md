# Shopping List

## Some Technologies

* Java
* Jetty
* Gradle
* Spring // Spring Boot
* Cucumber
* Sonar
* H2

## Build the Application

./gradlew clean build

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

Use this example data:

X-Token-Session = "1cae11ac-f3cd-437a-9a00-a4a4a2715dc0"

X-Account-device-id = "1"

{
  "list-id-device": 2,
  "list-name": "Name 1",
  "items": [{
	"item-id-device": 11,
	"item-name": "Item 1",
	"is-checked": true,
	"quantity-description": "2"
   }, {
	"item-id-device": 12,
	"item-name": "Item 2",
	"is-checked": false,
	"quantity-description": "1"
   }]
}

## DataBase

I used H2 embedded for this task. To access:

http://localhost:8090/h2/console


## Tests

For this project I created a basic sample structure to BDD Tests with Cucumber.

This is a interesting article about Microservices Testing:

https://martinfowler.com/articles/microservice-testing/

### Component Tests

Run the class TestCucumberSuiteRunner to see the execution of the tests.

## SonarQube

I used in this project. Sonar is tool for continuous inspection of code. You can also check the test coverage.
 
To run:

./gradlew clean sonarqube

It's very easy to use a sample. You only need to download a Docker image:

Execute: docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube

I put in the folder Sonar some inspection examples of this Application.