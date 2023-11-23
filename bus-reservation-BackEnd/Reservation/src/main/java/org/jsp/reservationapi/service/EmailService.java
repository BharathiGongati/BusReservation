package org.jsp.reservationapi.service;

import org.jsp.reservationapi.dto.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public String sendEmail(EmailConfiguration config)
	{
		MimeMessage message=mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setTo(config.getTo());
			helper.setText(config.getText());
			helper.setSubject(config.getSubject());
			mailsender.send(message);
			return "mail sent";
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "mail not sent";
		}
	
	}

}
