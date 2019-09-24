# FasTip
> Tipping Service

## Requirements
The minimum requirement by this project is Java version: 1.8.0

### Maven and NodeJS (NPM)
* [Apache Maven 3.6.*](https://maven.apache.org/install.html)
* [NodeJS (npm)](https://nodejs.org/en/)
* [Beanstalkd](http://kr.github.io/beanstalkd/download.html)


### Appium
* [Appium](https://www.npmjs.com/package/appium)

## Install Dependencies
`mvn clean install -DskipTests=true`

## Run Appium

`appium -p <port>`

Add change test port to Appium port in BaseTest file

## Run Test
`mvn test`