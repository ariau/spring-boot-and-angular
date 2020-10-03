@echo off
Rem Code coverage script for Windows OS

call mvn test
call mvn jacoco:report

start target\site\jacoco\index.html
