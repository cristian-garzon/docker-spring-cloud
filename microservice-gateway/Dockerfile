FROM openjdk:11.0
VOLUME /tmp
EXPOSE 8090
ADD ./target/microservice-gateway-0.0.1-SNAPSHOT.jar microservice-gateway.jar
ENTRYPOINT ["java","-jar","/microservice-gateway.jar"]