## Excersice 1

###### DepartmentStores Application
===================================

Requirements 

For building and running the application you need:

[JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
[Maven 3](https://maven.apache.org/)
[Apache tomcat 8.5](https://tomcat.apache.org/download-80.cgi)
[Postman](https://www.getpostman.com/apps)
[Google Chrome](https://www.google.com/chrome/?brand=CHBD&gclid=CjwKCAjw8uLcBRACEiwAaL6MST1PbhlGn9Z6y1G_Trmh_pPXwEJFGSLmvxw5FlNJz3Yoc2F7zfHHZxoCDxkQAvD_BwE&gclsrc=aw.ds&dclid=CJ-g3bKkt90CFVGkjgodzoIPkA)

Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.inm.stores.DepartmentStores.DepartmentStoresApplication class from your IDE.

Alternatively you can use the Maven build and deploy into tomcat like so:

```
mvn clean install
```

It will create DepartmentStores-0.0.1-SNAPSHOT.war

Place the generated war file into <Installed Tomcat Directory>/webapps/

**Restart tomcat** 

`Installed Tomcat Directory`/bin/shutdown.bat

`Installed Tomcat Directory`/bin/startup.bat

**Example**
```C:\apache-tomcat-8.5.32\webapps```

**To launch the application from chrome**

open this url in chrome browser

http://localhost:*tomcat port*/home

**Example**
```http://localhost:8080/home```


## Excersice 2

###### ContactApp
=================

Requirements 

For running the application you need:

[Google Chrome](https://www.google.com/chrome/?brand=CHBD&gclid=CjwKCAjw8uLcBRACEiwAaL6MST1PbhlGn9Z6y1G_Trmh_pPXwEJFGSLmvxw5FlNJz3Yoc2F7zfHHZxoCDxkQAvD_BwE&gclsrc=aw.ds&dclid=CJ-g3bKkt90CFVGkjgodzoIPkA)

Open the file ContactApp/contacts.html file with chrome browser
