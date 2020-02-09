package kw.raport.model.emailSender;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import javax.activation.*;

public class SendAttachment {
	public static void sendEmailTo(String targetEmail, ByteArrayOutputStream outputStream) {
		System.out.println("begin message sent....");
		String to = targetEmail;// change accordingly
		final String user = "raporty.z.kw@gmail.com";// change accordingly
		final String password = "Raporty2020!";// change accordingly

		// 1) get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		
		properties.put("mail.smtp.auth", "true");
		
		properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
      

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// 2) compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Message Alert");

			// 6) set the multiplart object to the message object
			message.setContent(generateAttachment(outputStream, "Raport.docx", "To jest wiadomość z Generatora raportów z ksiąg wieczystych"));
		
			// 7) send message
			Transport.send(message);

			System.out.println("message sent....");

			
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	
	private static MimeMultipart generateAttachment(ByteArrayOutputStream  attachmentByte, String filename, String body) throws MessagingException {
	    MimeMultipart res = new MimeMultipart();
	    byte[] poiBytes = attachmentByte.toByteArray();  
	    try {
			attachmentByte.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    DataSource dataSource = new ByteArrayDataSource(poiBytes, "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	    BodyPart attachmentBodyPart = new MimeBodyPart();
	    attachmentBodyPart.setDataHandler(new DataHandler(dataSource));
	    attachmentBodyPart.setFileName(filename);

	    BodyPart textBodyPart = new MimeBodyPart();
	    textBodyPart.setText(body);
	    textBodyPart.setContent(body, "text/html; charset=utf-8");

	    res.addBodyPart(textBodyPart);
	    res.addBodyPart(attachmentBodyPart);
	    return res;
	}
}