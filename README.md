# 🚀 Modern Web Automation Framework (E-Commerce)

[![Java](https://img.shields.io/badge/Language-Java24-orange)](https://www.oracle.com/java/)
[![Selenium](https://img.shields.io/badge/Tool-Selenium4-green)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/Runner-TestNG-blue)](https://testng.org/)
[![Allure](https://img.shields.io/badge/Reporting-Allure-red)](https://allurereport.org/)

## 📝 Project Overview
This is a high-end, industry-standard web automation framework designed for the **Automation Exercise** e-commerce platform. It demonstrates advanced concepts like **Page Object Model (POM)**, **Data Externalization**, and **CI/CD Readiness**.

### 🌟 Why this project is special?
- **Ad-Blocker Integration:** Implemented custom JavaScript-based ad suppression to handle intrusive Google Ads, ensuring 100% test stability.
- **Dynamic Element Handling:** Used **Explicit Waits** and **JS Executors** to manage flaky elements and pop-ups.
- **Smart Reporting:** Integrated **TestNG Listeners** to capture automatic screenshots on failure and generate beautiful Allure Dashboards.
- **Clean Code (OOP):** Strictly followed DRY (Don't Repeat Yourself) principles and Inheritance.

---

## 🏗️ Project Structure
```text
modern-web-automation-framework
├── src/main/java
│   └── com.framework
│       ├── driver       # Browser management (Driver Factory)
│       ├── pages        # Page Objects (The "Map" of the site)
│       └── utils        # Config Readers, Listeners, and Ad-Killers
├── src/test/java
│   └── com.framework
│       ├── tests        # Test Scenarios (Login, Cart, Checkout)
│       └── base         # BaseTest for Setup and TearDown
├── src/test/resources
│   ├── config.properties # Global configurations (URL, Browser)
│   └── testdata.properties # Test Data (Users, Cards)
└── pom.xml              # Dependency Management

```
## 🧪 Test Scenarios Covered
```
1. Registration: 5 Scenarios
2. User Authentication: 5 Scenarios 
3. Product Management: 5 Scenarios
4. Cart & Shopping: 5 Scenarios 
5. Checkout & Payment: 5 Scenarios 

```

## 📊 Reporting (Allure)
The framework generates rich visual reports. On test failure, it automatically attaches a high-res screenshot to the report.

![Screenshot of a after the running of all tests and generate allure report according to result.](/screenshot/result.png)

## 🚀 How to Run Locally


Clone: 
```terminaloutput
git clone https://github.com/chandimananayakkara/modern-web-automation-framework.git 
```
<br>
Setup: Ensure Java 17+ and Maven are installed.
Run: Execute the included run_tests.bat or run:


Bash

```terminaloutput

mvn clean test
View Report:
Bash

allure serve allure-results

```

Developed by: Chandima Nanayakkara <br>
Quality Assurance Automation Engineer

