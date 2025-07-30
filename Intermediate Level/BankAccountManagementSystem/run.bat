@echo off
cd /d "%~dp0"
javac -d out -cp "lib/*" src\main\java\com\shadowfox\bankingapp\*.java
java -cp "out;lib/*" com.shadowfox.bankingapp.BankAccountApp
pause
