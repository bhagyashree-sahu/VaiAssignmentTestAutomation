# VAI Automation Framework
## _Test Automation  Project_

- Java 1.8
- Maven
- TestNG
- Cucumber
- Rest Assured


## Features

- Performs API Automated Tests for VAI API
- Categorizing the Tests in both TestNG and Cucumber


## Tech

Framework uses a number of dependencies to work properly:

- TestNG
- Cucumber
- Cucumber TestNG
- Rest Assured
- JsonSchemaValidator
- Java-Faker

## Adding New Dependencies

New Dependencies can be added in pom.xml at root level under dependencies tag

Example
```
<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>5.1.1</version>
			<scope>test</scope>
		</dependency>
```



## Plugins

Maven Plugins used in the Project
<table>
  <tr><th>Plugin</th><th>README</th></tr>
  <tr><td>Maven SureFire Plugin- </td><td>https://maven.apache.org/surefire/maven-surefire-plugin </td></tr>
    <tr><td> Exec Maven Plugin -</td><td>https://www.mojohaus.org/exec-maven-plugin/ </td></tr>
</table>




### To Run the Automated Test for TestNG from cli...

```sh
mvn -Dexec.classpathScope=test  -Dexec.arguments="qa,api,sanity" test-compile  exec:java -Dexec.cleanupDaemonThreads=false -X
```


### To Run the Automated Test for Cucumber from cli...

```sh
mvn test -X
```

