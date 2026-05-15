# MavenTest1 Project

## Description
MavenTest1 is a simple Java application that serves as an example project to demonstrate the structure and functionality of a Maven-based project. It includes a main application class, configuration properties, and unit tests.

## Project Structure
```
MavenTest1
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── App.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── AppTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## Installation
To build and run the project, ensure you have Maven installed on your machine. Clone the repository and navigate to the project directory. Then, run the following command to build the project:

```
mvn clean install
```

## Usage
After building the project, you can run the application using the following command:

```
mvn exec:java -Dexec.mainClass="com.example.App"
```

## Testing
To run the unit tests, use the following command:

```
mvn test
```

## Configuration
The application configuration can be found in the `src/main/resources/application.properties` file. Modify this file to change application settings as needed.