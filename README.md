# springboot-kafka-wikimedia-realtime

1. Parent Module: `springboot-kafka-wikimedia-realtime`
2. Child Module:
   - `kafka-producer-wikimedia` 
     - Creating kafka topic and its related definition for kafka topic (replicas and partitions)
     - Event Handler Implementation (i.e. implements `EventHandler` ) : Trigger onMessage() when ever any new message arrives
     - Producer to fetch data from URL ("https://stream.wikimedia.org/v2/stream/recentchange") and start the event handler
     - Producer should have serializer (i.e. StringSerializer, JsonSerializer) in pom definition
   - `kafka-consumer-wikimedia`
     - Read data from kafka broker using topic name and groupId
     - Saves the data into Postgres DB
     - Consumer should have deserializer (i.e. StringDeserializer, JsonDeserializer) in pom definition

# Stack:
1. Java 17
2. Spring Boot
3. JPA
4. Lombok
5. Jackson
6. Eventsource
7. Kafka
8. ~~MySQL (Create database springboot_kafka)~~ Postgres (Create database _springboot_kafka_ and schema _wikimedia_data_)

# EVENT-DRIVEN Architecture
- EDA can asynchronously publish and subscribe to events via event/message broker.
- EDA applications communicate with each other by sending and/or receiving  events/messages/

## Docker Approach:
1. Execute below command to start the docker compose
```bash
docker-compose up -d
```

2. Execute below command to stop the docker compose
```bash
docker-compose down
```

3. To check (follow) the logs of docker compose
```bash
docker-compose logs -f
```

4. To check the logs of individual container
```bash
docker logs -f <container-name>
```



