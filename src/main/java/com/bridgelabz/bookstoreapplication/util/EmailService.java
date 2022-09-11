package com.bridgelabz.bookstoreapplication.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

//    public String sendEmail() {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("sharadgb567@gmail.com");
//        message.setTo("sharadgb567@gmail.com");
//        message.setSubject("Trying to send...");
//        message.setText("Hi dear .. ");
//
//        javaMailSender.send(message);
//
//        return "Mail sent Successfully";
//    }

    public void sendEmail(Object emailId, String string, String string2) {
        // TODO Auto-generated method stub
    }

    public String sendEmail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom("sharadgb567@gmail.com");
            mimeMessageHelper.setTo("sharadgb567@gmail.com");
            mimeMessageHelper.setSubject("Trying to send...");
            mimeMessageHelper.setText("Hi dear .. ");
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (Exception e) {
            return "Mail sent failed";
        }
    }
}
