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

![image](https://user-images.githubusercontent.com/42631714/60142518-870ff200-97fd-11e9-8451-e2d2e62bd467.png)

![image](https://user-images.githubusercontent.com/42631714/60142644-06052a80-97fe-11e9-9d43-2c71f67bfd25.png)

![image](https://user-images.githubusercontent.com/42631714/60142667-2e8d2480-97fe-11e9-9d0e-5d5ce0ad9710.png)

![image](https://user-images.githubusercontent.com/42631714/60142686-4795d580-97fe-11e9-9d5d-f5033e9cd1b2.png)

![image](https://user-images.githubusercontent.com/42631714/60142743-8461cc80-97fe-11e9-845d-49185bedd14e.png)










