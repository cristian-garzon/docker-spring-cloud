FROM openjdk:11.0
VOLUME /tmp
EXPOSE 8761
ADD ./target/microservice-eureka-0.0.1-SNAPSHOT.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]