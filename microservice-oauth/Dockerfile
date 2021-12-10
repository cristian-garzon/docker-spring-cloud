FROM openjdk:11.0
VOLUME /tmp
EXPOSE 9100
ADD ./target/microservice-oauth-0.0.1-SNAPSHOT.jar microservice-oauth.jar
ENTRYPOINT ["java","-jar","/microservice-oauth.jar"]