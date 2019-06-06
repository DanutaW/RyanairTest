# Run

```
mvn clean test -Dwebdriver.chrome.driver=path-to-chromedriver-executable
```

# Generate report

```
mvn allure:report
```

Example report is included in _EXAMPLE-REPORT_ directory (works in _Edge_ & _Firefox_).

# Motivation

I choosed _Java_ because I have the most experience with this language.
The reason for using _Page Object Pattern_ is that it makes test cases more readable and maintainable.
_Allure_ gives comprehensive and professionally looking reports.
