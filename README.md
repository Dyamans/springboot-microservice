# springboot-microservice

This is a user registration microservice running in a docker container. Routing through Zuul and cline  service registered in Eureka Service.

# Software used

Spring boot,
Spring cloud Eureka,
Spring cloud Zuul,
Maven,
Docker,
Docker compose,
JDK 1.8

Build and Deploy
-----------------
run the (clean and package commands) pom.xml under springbootmicroservices folder. Jars will be crated in the target folder then run the command docker-compose up to build the images.

# Services

Eureka Service,
User Registration service (reg-service),
Email Service (email-service)

#Service URL
Eureka Dash Board URL
http://your-docker-ip:8302/
![image](https://user-images.githubusercontent.com/42631714/60096346-079a0880-9794-11e9-8fea-50d01645d587.png)

User Registration end points URL
http://your-docker-ip:8302/reg-service/swagger-ui.html
![image](https://user-images.githubusercontent.com/42631714/60096466-5c3d8380-9794-11e9-9b9e-9ea33e4588da.png)



Email Service
http://your-docker-ip:8302/email-service/


Testing data:
-------------

insert a user:

{
  "id": 1,
  "name": "John",
  "phone": "0487736273"
  "deleteFlag": "false", 
  "email": "dd@gmail.com" 
}










