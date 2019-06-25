FROM openjdk:8
EXPOSE 8300
ADD target/reg-service.jar reg-service.jar
EXPOSE 8300
ENTRYPOINT ["java","-jar","reg-service.jar"]