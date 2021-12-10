FROM openjdk:11.0
VOLUME /tmp
ADD ./target/spring-boot-products-0.0.1-SNAPSHOT.jar microservice-product.jar
ENTRYPOINT ["java","-jar","/microservice-product.jar"]