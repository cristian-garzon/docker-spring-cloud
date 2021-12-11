FROM openjdk:11.0
VOLUME /tmp
ADD ./target/microservice-item-0.0.1-SNAPSHOT.jar microservice-item.jar
ENTRYPOINT ["java","-jar","/microservice-item.jar"]