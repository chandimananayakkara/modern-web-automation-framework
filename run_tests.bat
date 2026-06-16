@echo off
call mvn clean test
echo Generating Allure Report...
call allure serve allure-results
pause