FROM openjdk:8
EXPOSE 8301
ADD target/email-service.jar email-service.jar
EXPOSE 8301
ENTRYPOINT ["java","-jar","email-service.jar"]