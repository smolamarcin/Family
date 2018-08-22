##In order to run, you need:
>JDK 8 <br>
>Maven <br>
>Docker <br>

##First, you have to be in a docker group.
Try to run:
>docker run hello-world

If everything is fine, go to the next steps.

To run tests, type:
>mvn test

First, you need to build back-end:
>mvn clean install

For create 3 containers including Spring boot app, Angular app and database run:
>mvn pre-site

Containers should be created. The default profile for containers in production. 
You can change it in the .env file. Now available are:
>test <br>
>prod <br>