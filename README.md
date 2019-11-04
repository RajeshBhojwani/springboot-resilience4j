# springboot-resilience4j

This code is built to showcase how to use resilience4j and micrometer library along with spring-boot.
It has implemented CircuitBreaker, RateLimit, Retry and Bulkhead features.

## Requirements
JDK 1.8

## Getting Started

It has two projects
 librarymanangement
 bookmanangement
 librarymanangement calls bookmanagement service.

Start both the applications -

Book Management Service
  gradlew build
  
  java -jar build/libs/bookmanangement-0.0.1-SNAPSHOT.jar

  url -  http://localhost:8083/books

Library Management Service
Change the url of Book Management service in LibraryConfig.java file (localhost or PCF url)
 
  gradlew build
  
  java -jar build/libs/librarymanangement-0.0.1-SNAPSHOT.jar

  url -  http://localhost:8084/library

  Test the Get/Post methods with Swagger UI- http://localhost:8084/swagger-ui.html to ensure app methods working.
  
 All the patterns are implemented in librarymanangement code.

## Test the patterns   
     
###  CircuitBreaker Pattern -
      First check the librarymanangement health url - http://localhost:8084/actuator/health 
      to see circuitbreaker metrics exposed through Prometheus
      It should show the state 'Closed' if the application is workin fine.
      
      Now, Stop the bookmanagement application.
      Test the Post method with Swagger UI- http://localhost:8084/swagger-ui.html
      Check the health url of librarymanagement - It should show the circuit state is 'Open'



