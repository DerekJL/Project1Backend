package com.revature.util;

//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailHelper {

   public static void sendEmail(String to) {    
     
	   		String from = "djloisel19@gmail.com";
	   		String fromPass = "ILoveMyFamily1919";
	   		final String username = from;
	   		final String password = fromPass;

	   		Properties props = new Properties();
	   		props.put("mail.smtp.auth", "true");
	   		props.put("mail.smtp.starttls.enable", "true");
	   		props.put("mail.smtp.host", "smtp.gmail.com");
	   		props.put("mail.smtp.port", "587");

	   		Session session = Session.getInstance(props,
	   		  new javax.mail.Authenticator() {
	   			protected PasswordAuthentication getPasswordAuthentication() {
	   				return new PasswordAuthentication(username, password);
	   			}
	   		  });

	   		try {

	   			Message message = new MimeMessage(session);
	   			message.setFrom(new InternetAddress(from));
	   			message.setRecipients(Message.RecipientType.TO,
	   				InternetAddress.parse(to));
	   			message.setSubject("WorkMeOut Password Reset");
	   			message.setText("Follow the link below to reset your password\n http://localhost:4200/recovery");

	   			Transport.send(message);

	   			System.out.println("Email sent");

	   		} catch (MessagingException e) {
	   			throw new RuntimeException(e);
	   		}
	   	
	   
   }
}