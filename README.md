# Test Automation framework for Web-API-Mobile
This Repository stores modules for Web, API & Mobile Automation testing </br>

<h3> Getting Started </h3>
Here are the prerequisites you need to setup. 

<b>Commonly used to all the modules:</b>
- Java JDK
- Maven 
- IntelliJ
- Lombok (IntelliJ Plugin)

<b>For Mobile Module:</b>
- NodeJS
- Appium Server GUI
- Android SDK

<h3> Dependencies </h3>
Dependencies used for the project with the versions

- Appium Java Client 7.5.1
- Selenium Java 3.141.59
- WebDriver Manager 5.3.1
- TestNG 7.3.0
- RestAssured 5.3.0
- Jackson Annotations 2.13.4
- Jackson Databind 2.14.2
- Lombok 1.18.26
- Allure 2.13.2

<h3> Environment Configurations </h3>
Environment variables to be setup:

- JAVA_HOME
- MAVEN_HOME
- ANDROID_HOME
- Add bin paths to 'Path' 
- Add Android SDK platforms, platform-tools, build-tools paths to 'Path'

Run following commands to see if the configurations are set.
- Java > java -version
- ADB devices > adb devices

<h3> Reporting </h3>

Allure reports integrated for reporting

<h3> Setting up the project </h3>

[test-api-ui-mobile repository](https://github.com/RochelleAbeywickrama/test-api-web-mobile.git)

Clone the project to your local and build the project successfully.

```bash
# Clone this repository
$ git clone https://github.com/RochelleAbeywickrama/test-api-web-mobile.git

# Build Project
$ mvn clean install
```

If the initial configurations and prerequisites are done, you can execute  the API & UI tests. </br>
Before executing the mobile tests, you need to make sure the Appium server is up and running as well as the emulator.


# TODO List:

- [X] Api Automation suite
- [X] Web Automation suite
- [X] Mobile Automation suite
- [X] Add Testcases document to the test resources
- [X] Allure-reporting


## Related

[Maven Repository](https://mvnrepository.com/)
[IntelliJ](https://www.jetbrains.com/idea/download/#section=windows)
[Android Studio](https://developer.android.com/studio)
[Appium Server GUI](https://github.com/appium/appium-desktop)
[NodeJS](https://nodejs.org/en)