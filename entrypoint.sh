#!/bin/sh

if [ "$MODE" = "producer" ]; then
  java -jar kafka-producer-wikimedia-0.0.1-SNAPSHOT.jar
elif [ "$MODE" = "consumer" ]; then
  java -jar kafka-consumer-database-0.0.1-SNAPSHOT.jar
else
  echo "Please set the MODE environment variable to 'producer' or 'consumer'"
fi
