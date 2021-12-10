FROM openjdk:11.0
VOLUME /tmp
EXPOSE 8090
ADD ./target/microservice-zuul-0.0.1-SNAPSHOT.jar microservice-zuul.jar
ENTRYPOINT ["java","-jar","/microservice-zuul.jar"]