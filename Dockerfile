FROM openjdk:17-alpine
ADD target/numberProducer-0.0.1-SNAPSHOT.jar numberProducer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","numberProducer-0.0.1-SNAPSHOT.jar"]
