package com.capg.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.capg.model.Users;

@Service
public class EmailSenderService {

	/*
	 * @Autowired SignUpDao sud;
	 * 
	 * 
	 * public UsersDetails SignUP(UsersDetails user) { return sud.SignUP(user); }
	 * public UsersDetails confirmUserAccount(String confirmationToken) { return
	 * sud.ConfirmationToken(confirmationToken);
	 * 
	 * }
	 */

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	public EmailSenderService() {

		String emailPort = "587"; // gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

	}

	public void createEmailMessage(String user) {
		System.out.println("creating mail");

		try {

			System.out.println("creating mail");
			String toEmails = user;
			String emailSubject = "Reset Password";
			String emailBody = "\"To change your password click on the link \n "
					+ "\"http://localhost:4200/reset-password/";
			mailSession = Session.getDefaultInstance(emailProperties, null);
			emailMessage = new MimeMessage(mailSession);
			System.out.println("creating mail");
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));

			emailMessage.setSubject(emailSubject);
			emailMessage.setText(emailBody);
			System.out.println("creating mail");
			// emailMessage.setContent(emailBody, "text/html");
			// for a html email
			// emailMessage.setText(emailBody);// for a text email

		} catch (MessagingException ex) {
			System.out.println(ex);
		}
	}

	public void createEmailMessage(Users user, String token) {
		try {
			String toEmails = user.getEmail();
			String emailSubject = "Verify your account";
			String emailBody = "\"To confirm your account, please click here: \n " + "\"http://localhost:8081/register/"+token;
			//http://localhost:8081/confirm-account/"+token
			mailSession = Session.getDefaultInstance(emailProperties, null);
			emailMessage = new MimeMessage(mailSession);
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails));

			emailMessage.setSubject(emailSubject);
			emailMessage.setText(emailBody);

//emailMessage.setContent(emailBody, "text/html");
//for a html email
//emailMessage.setText(emailBody);// for a text email

		} catch (MessagingException ex) {
			System.out.println(ex);
		}
	}

	public void sendEmail() {

		try {

			System.out.println("sending mail");
			String emailHost = "smtp.gmail.com";
			String fromUser = "banda.rahulreddy"; // just the id alone without @gmail.com
			String fromUserEmailPassword = "2488354061";

			Transport transport = mailSession.getTransport("smtp");

			transport.connect(emailHost, fromUser, fromUserEmailPassword);
			transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
			transport.close();
			System.out.println("Email sent successfully.");
		} catch (MessagingException ex) {
			System.out.println(ex);
		}
	}

}
