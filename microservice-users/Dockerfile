FROM openjdk:11.0
VOLUME /tmp
ADD ./target/microservice-users-0.0.1-SNAPSHOT.jar microservice-users.jar
ENTRYPOINT ["java","-jar","/microservice-users.jar"]