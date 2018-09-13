Excersice 1

DepartmentStores Application
============================

Requirements 

For building and running the application you need:

JDK 1.8
Maven 3
Apache tomcat 8.5
Postman
Chrome

Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the de.codecentric.springbootsample.Application class from your IDE.

Alternatively you can use the Maven build and deploy into tomcat like so:

mvn clean install

It will create DepartmentStores-0.0.1-SNAPSHOT.war

Place the generated war file into <Installed Tomcat Directory>/webapps/

Restart tomcat 
<Installed Tomcat Directory>/bin/shutdown.bat
<Installed Tomcat Directory>/bin/startup.bat

To launch the application from chrome 
http://localhost:<tomcat port>/home