### Wearhealth Cloud

## Setup
>Run ```mvn clean package``` in the folder, where the file pom.xml locates in,
for building the application.

## Prerequisites & Configuration
> Installation of mysql
> configuring of mysql settings in app [application.properties]

```
spring.datasource.url = [mysql port and database]
spring.datasource.username = [mysql username]
spring.datasource.password = [mysql password]
```
## Install
VICINITY Adapter for Wearhealth is being developed in Java 8 and uses Spring Boot Framework ```2.1.6.RELEASE```, thus it can be
installed via -

```
mvn clean install
```
## DEPLOY
> Deploy this application in the local server and use this application as REST API application.
To store data in the cloud.
