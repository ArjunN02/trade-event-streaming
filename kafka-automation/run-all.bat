echo 🟢 Starting ZooKeeper...
start cmd /k "C:\kafka\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties"

timeout /t 10

echo 🟢 Starting Kafka broker...
start cmd /k "C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server.properties"

timeout /t 15

echo 🟢 Creating topic (if not exists)...
bin\windows\kafka-topics.bat --create --if-not-exists --topic trade-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

timeout /t 5

echo 🟢 Producing 10 trade messages...
call C:\Users\LENOVO\Desktop\trade-dashboard\kafka-automation\produce-trades.bat

timeout /t 5

echo 🟢 Starting Spring Boot app...
cd /d C:\Users\LENOVO\Desktop\trade-dashboard
start cmd /k ".\mvnw spring-boot:run"
