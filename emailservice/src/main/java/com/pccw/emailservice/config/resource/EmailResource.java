package com.pccw.emailservice.config.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class EmailResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private JavaMailSender javaMailSender;

    public static final Logger logger = LoggerFactory.getLogger(EmailResource.class);


    @RequestMapping(value = "/email/{emailId}", method = RequestMethod.GET)
    public String sendEmail(@PathVariable("emailId") final String emailId){

        logger.info("Sending an email to the user email id: " + emailId);

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(emailId);

        msg.setSubject("Your registration success");
        msg.setText(" Thanks for user registraion with us! " +
                "We're excited to help you learn spring boot " +
                "microservices and how to code");

        msg.setFrom("noreply@domain.com");

        javaMailSender.send(msg);

        return "Email notification sent to the registered user";
    }
}
