# README

## Project Overview

This project is an automated testing framework using **Selenium WebDriver**, **Cucumber**, **TestNG**, and **Allure** for reporting.

## Folder Structure

```
project-root/
│—— src/
│   ├—— main/   (Empty, since this is a test project)
│   ├—— test/
│   │   ├—— java/
│   │   │   ├—— definitions/
│   │   │   │   ├—— Hooks.java
│   │   │   │   ├—— LoginPageDefinitions.java
│   │   │   ├—— runners/
│   │   │   │   ├—— CucumberRunnerTests.java
│   │   ├—— resources/
│   │   │   ├—— features/
│   │   │   │   ├—— login.feature
│—— pom.xml
│—— testng.xml
│—— README.md
```

## Prerequisites

Ensure the following are installed:

- Java 17+
- Maven
- Chrome Browser
- ChromeDriver (matching Chrome version)

## Setup & Installation

1. Clone the repository:
   ```sh
   git clone <repo-url>
   cd <repo-folder>
   ```
2. Install dependencies:
   ```sh
   mvn clean install
   ```

## Running Tests

- To execute tests using **Maven**:
  ```sh
  mvn test
  ```
- To generate an **Allure Report**:
  ```sh
  mvn allure:report
  ```

## Reporting

- **Allure Reports** are generated in `target/allure-results/`
- Open the report using:
  ```sh
  allure serve allure-results/
  ```

## Environment Configuration

Modify `environment.properties` inside `target/allure-results/` to set test environment details.

---

### **Troubleshooting**

- If **WebDriverException** occurs, update your ChromeDriver.
- If **Allure results are outside **``, check `pom.xml` allure plugin configuration.
- Ensure **Java & Maven paths** are correctly set in system environment variables.

For further assistance, refer to the official documentation of **Selenium, Cucumber, TestNG, and Allure**.

