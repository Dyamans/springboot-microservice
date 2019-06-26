# springboot-microservice

This is an user registration microservice application running in a docker container. Routing through Zuul and client services registered in Eureka Service.

User Registration Architecture
---------------------------------

![image](https://user-images.githubusercontent.com/42631714/60142518-870ff200-97fd-11e9-8451-e2d2e62bd467.png)

Software used
-----------------

Spring boot version 2.1.3
Spring cloud version Greenwich.SR1
Spring cloud Eureka latest
Spring cloud Zuul latest
Maven,
Docker version 18.09.0
Docker compose,
JDK 1.8

Build and Deploy
-----------------
run the (clean and package commands) pom.xml under springbootmicroservices folder. Jars will be crated in the target folder then run the command docker-compose up to build the images and then test the functionality.

Services
------------------
Eureka Service,
User Registration service (reg-service),
Email Service (email-service)

For zuul configuration review, please check the .yml file under EurekaServer resource folder.

Service URL
------------------
Eureka Dash Board URL
http://your-docker-ip:8302/
![image](https://user-images.githubusercontent.com/42631714/60096346-079a0880-9794-11e9-8fea-50d01645d587.png)

User Registration end points URL
http://your-docker-ip:8302/reg-service/swagger-ui.html
![image](https://user-images.githubusercontent.com/42631714/60096466-5c3d8380-9794-11e9-9b9e-9ea33e4588da.png)



Complte end points
--------------------
find a user (GET)
http://dockerip:8302/reg-service/api/user/1

find all users (GET)
http://dockerip:8302/reg-service/api/users/

Update an user (PUT)
http://dockerip:8302/reg-service/api/user/1

Delete an user
http://dockerip:8302/reg-service/api/user/1  (Single user deletion with soft deletion)

Send an email through email service
http://docker-ip:8302/email-service/api/email/your-email-id





Testing data:
-------------

inserting an user:

{
  "id": 1,
  "name": "John",
  "phone": "valid phone number"
  "deleteFlag": "false", 
  "email": "valid email id" 
}


Create user through swagger API
--------------------------------
![image](https://user-images.githubusercontent.com/42631714/60142644-06052a80-97fe-11e9-9d43-2c71f67bfd25.png)



Email Notification
-----------------------------

![image](https://user-images.githubusercontent.com/42631714/60142686-4795d580-97fe-11e9-9d5d-f5033e9cd1b2.png)

Users in the H2 Database
-----------------------------

You can use http://docker-ip:8300/h2 to view the H2 Dashboard, you can refer the password from application.prop

![image](https://user-images.githubusercontent.com/42631714/60142743-8461cc80-97fe-11e9-845d-49185bedd14e.png)
