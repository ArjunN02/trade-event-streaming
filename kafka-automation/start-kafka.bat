@echo off
cd /d C:\kafka

start cmd /k "bin\windows\zookeeper-server-start.bat config\zookeeper.properties"
timeout /t 10

start cmd /k "bin\windows\kafka-server-start.bat config\server.properties"
timeout /t 15
