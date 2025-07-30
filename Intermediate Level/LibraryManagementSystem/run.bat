@echo off
cd /d "%~dp0"
javac -cp "lib\sqlite-jdbc-3.36.0.3.jar" -d out src\main\java\com\shadowfox\library\*.java
java -cp "out;lib\sqlite-jdbc-3.36.0.3.jar" com.shadowfox.library.LibraryApp
pause
