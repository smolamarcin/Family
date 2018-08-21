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

For create 3 containers including Spring boot app, Angular app and database run:
>mvn clean install

Containers should be created. The default profile for containers in production. 
You can change it in the .env file. Now available are:
>test <br>
>prod <br>