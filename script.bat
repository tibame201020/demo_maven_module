@echo off

rem 根據datasource.properties產生bean.xml與相關java file
cd dao\src\main\resources\
call java -jar generateJdbcBeans.jar
cd ..\..\..\..\
cd util\
call mvn clean install
cd ..\dao\
call mvn clean install
cd ..\
call mvn clean install