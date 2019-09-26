# FasTip
> Tipping Service

## Requirements
The minimum requirement by this project is Java version: >= 8

* [Java 8](https://java.com/en/download/help/download_options.xml)
* [Apache Maven 3.6.*](https://maven.apache.org/install.html)
* [NodeJS (npm)](https://nodejs.org/en/)
* [Android Studio](https://developer.android.com/studio)


## Install Dependencies
`npm i -g appium`

`mvn clean install -DskipTests=true`

## Run Appium

Change test port to Appium port of your choosing in src/test/java/tests/BaseTest.java file

Run command below with the port in the BaseTest file

`appium -p <port>`

## Run Test
Change path of apk in src/test/java/tests/BaseTest.java file to the path of the apk in the main directory of the project.
 
Open a working directory of the project in a new terminal.

Run the command below

`mvn test`