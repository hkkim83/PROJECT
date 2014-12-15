package kr.co.aegis.service;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	 
    @Autowired
    private JavaMailSender mailSender;
 
    /**
     * 메일 보내기
     * @param map
     */
    public void sendMail(Map<String, String> map) {
        MimeMessage message = mailSender.createMimeMessage();
 
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            String toUserList[] = map.get("toUser").split(",");
            messageHelper.setSubject(map.get("subject"));
            messageHelper.setTo(toUserList);
            messageHelper.setFrom(map.get("fromUser"));
            messageHelper.setText(map.get("text"), true);
            mailSender.send(message);
 
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
