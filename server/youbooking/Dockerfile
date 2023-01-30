#FROM tomcat:latest
FROM openjdk:11
LABEL maintainer="example.com"
EXPOSE 8080
COPY ./target/spring-boot-docker-youbooking.jar spring-boot-docker-youbooking.jar
ENTRYPOINT ["java","-jar" , "/spring-boot-docker-youbooking.jar"]