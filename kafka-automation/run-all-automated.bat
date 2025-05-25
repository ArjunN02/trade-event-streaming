@echo off
echo ================================
echo Starting ZooKeeper...
echo ================================
start "ZooKeeper" cmd /k "cd /d C:\kafka && bin\windows\zookeeper-server-start.bat config\zookeeper.properties"
timeout /t 5 > nul

echo ================================
echo Starting Kafka broker...
echo ================================
start "Kafka" cmd /k "cd /d C:\kafka && bin\windows\kafka-server-start.bat config\server.properties"
timeout /t 10 > nul

echo ================================
echo Creating Kafka topic (ignore error if already exists)...
echo ================================
cd /d C:\kafka
bin\windows\kafka-topics.bat --create --topic trade-events --bootstrap-server localhost:9092 --partitions 2 --replication-factor 1
timeout /t 5 > nul

echo ================================
echo Starting Spring Boot application...
echo ================================
start "Spring Boot" cmd /k "cd /d C:\Users\LENOVO\Desktop\trade-dashboard_auto && .\mvnw spring-boot:run"
timeout /t 25 > nul

echo ================================
echo Sending POST request to generate 500 trades...
echo ================================
curl -X POST "http://localhost:8080/api/trades/generate?count=500"

echo ================================
echo Done. Verify trades in PostgreSQL.
echo ================================
pause
