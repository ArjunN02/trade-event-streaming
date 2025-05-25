@echo off
cd /d C:\kafka

rem Optional: create topic if not already exists
bin\windows\kafka-topics.bat --create --if-not-exists --topic trade-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

rem Produce 10 JSON trade events from a file
type "%~dp0trades.json" | bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic trade-events
