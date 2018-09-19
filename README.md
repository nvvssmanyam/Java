###### Excersice 1

## DepartmentStores Application

Requirements 

For building and running the application you need:

[JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[MySQL](https://dev.mysql.com/downloads/installer/)

[Maven 3](https://maven.apache.org/)

[Apache tomcat 8.5](https://tomcat.apache.org/download-80.cgi)

[Postman](https://www.getpostman.com/apps)

[Google Chrome](https://www.google.com/chrome/?brand=CHBD&gclid=CjwKCAjw8uLcBRACEiwAaL6MST1PbhlGn9Z6y1G_Trmh_pPXwEJFGSLmvxw5FlNJz3Yoc2F7zfHHZxoCDxkQAvD_BwE&gclsrc=aw.ds&dclid=CJ-g3bKkt90CFVGkjgodzoIPkA)

**Basic MySQL setup**

After installaion of MySQL, update the username and password in file _Project_Directory_/src\main\resources\application.properties

Execute the below query in mySQL console or Workbench to create schema which is used in DepartmentStores Appliction

```
CREATE DATABASE DepartmentStores;
```

That's it, remaining tables creation will be handle by code


**To Run the application locally**

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.inm.stores.DepartmentStores.DepartmentStoresApplication class from your IDE.

Alternatively you can use the Maven build and deploy into tomcat like so:

```
mvn clean install
```

It will create DepartmentStores-0.0.1-SNAPSHOT.war in project directory

Place the generated war file into _Installed Tomcat Directory_/webapps/

**Restart tomcat** 

_Installed Tomcat Directory_/bin/shutdown.bat

_Installed Tomcat Directory_/bin/startup.bat

**Example**
```C:\apache-tomcat-8.5.32\webapps```

**To launch the application from chrome**

open this url in chrome browser

http://localhost:_tomcat port_/departmentstores/home

**Example**
```http://localhost:8080/home```


###### Excersice 2

## ContactApp

Requirements 

For running the application you need:

[Google Chrome](https://www.google.com/chrome/?brand=CHBD&gclid=CjwKCAjw8uLcBRACEiwAaL6MST1PbhlGn9Z6y1G_Trmh_pPXwEJFGSLmvxw5FlNJz3Yoc2F7zfHHZxoCDxkQAvD_BwE&gclsrc=aw.ds&dclid=CJ-g3bKkt90CFVGkjgodzoIPkA)

Open the file ContactApp/contacts.html file with chrome browser
