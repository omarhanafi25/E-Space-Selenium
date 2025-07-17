
# 🧪 OrangeHRM UI Automation Framework

This project is a **Selenium-based UI test automation framework** for testing [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/). It uses Java 21, TestNG, Maven, and Extent Reports with the Page Object Model (POM) design pattern.

---

## 🚀 Tech Stack

- **Language**: Java 21
- **Automation**: Selenium WebDriver
- **Test Framework**: TestNG
- **Build Tool**: Maven
- **Reporting**: ExtentReports
- **Plugin**: Maven Surefire Plugin

---





## ⚙️ Setup Instructions

### 🔹 Prerequisites

- ✅ Java **21** installed and configured (`java -version`)
- ✅ Maven installed (`mvn -version`)
- ✅ IDE like IntelliJ or Eclipse (recommended)
- ✅ Chrome browser 

---

## ▶️ How to Run the Tests

### 1️⃣ Option A: Run from Terminal (Recommended)

From the root project directory, run:

```bash
mvn clean verify
```

> Runs all tests and generates Extent Report.

---

### 2️⃣ Option B: Run `testng.xml` (e.g., ESpace.xml)

Right-click the file in your IDE and choose:  
**Run as → TestNG Suite**

---

### 3️⃣ Option C: Run a Specific Class

Right-click on the class `EndToEndScenarios` in your test/regression package and select:  
**Run 'EndToEndScenarios'**

---

## 📊 Reports

After the test run, navigate to:

```
E-Space\reports
```

Open the `.html` file in any browser to see a detailed test report .
also you will find a folder for passed and failed screenshots

---

## 🧩 Design Pattern

The framework uses the **Page Object Model (POM)**:

- Each page has its own Java class.
- Clean separation of logic and test steps.
- Reusability and maintainability.


```

---

## ✅ Notes

- Test target: [https://opensource-demo.orangehrmlive.com/](https://opensource-demo.orangehrmlive.com/)
- You can extend tests for modules like login, PIM, leave, etc.
- Browser drivers can be managed using WebDriverManager or added manually.

---

## 👨‍💻 Author

- Omar Nabil 
- omarhefni25@gmail.com

---
