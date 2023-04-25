package com.job.back.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailProvider {
    @Autowired private JavaMailSender javaMailSender;

        public boolean sendMail() {
            try {
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom("1111@donga.ac.kr");
                simpleMailMessage.setTo("abc123@naver.com");
                simpleMailMessage.setSubject("제목");
                simpleMailMessage.setText("<p style='color: red;''>html 형식의 내용");
                javaMailSender.send(simpleMailMessage);
        }catch(Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }
}
