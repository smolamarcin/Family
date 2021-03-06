Travis status:
[![Build Status](https://travis-ci.com/smolamarcin/Family.svg?branch=master)](https://travis-ci.com/smolamarcin/Family)

Code coverage:
[![codecov](https://codecov.io/gh/smolamarcin/Family/branch/master/graph/badge.svg)](https://codecov.io/gh/smolamarcin/Family) <br>
<br>
## About the project
Here you have the family managment system. You can create your own family, add children to existing family and add father to existing family.
Also, you can filter families by different params.

The main goal of the project was to learn how to dockerize your application. The goal is achieved.
In the future I'll implement the front-end part. For "todo list     ttake a look in the backlog. For this moment, only backend and infrastructure works.

## In order to run, you need:
>JDK 1.8+ <br>
>Maven 3+<br>
>Docker <br>

If you don't have maven installed, just use ./mvnw instead of mvn in commands.

## First, you have to be in a docker group.
Try to run:
>docker run hello-world

## You have to be in docker group. If your're not, follow this steps:

Create the docker group:
>sudo groupadd docker

Add your user to the docker group.
>sudo usermod -aG docker $USER

Log out and log back in so that your group membership is re-evaluated.<br>
Try to run docker run hello-world once again.<br>
If everything is fine, go to the next steps. <br>

## To run unit tests    t, type:
>mvn test (or ./mvnw test)

## To run integration tests, type:
>mvn verify (or ./mvnw verify)


## Instruction for running an app:
First, you need to build back-end:
>mvn package (or ./mvnw package)

For create 3 containers including Spring boot app, Angular app and database run:
>mvn clean install (./mvnw clean install)

If you have issues with linking containers, try to change profile for "test" in .env file. 

Containers should be created. The default profile for containers in production. 
You can change it in the .env file. Now available are:
>test <br>
>prod <br>