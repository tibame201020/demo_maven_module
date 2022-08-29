@echo off

cd src\main\resources\
call java -jar generateJdbcBeans.jar
cd ..\..\..\
call mvn clean install
cd ..\
call mvn clean install
cd dao\