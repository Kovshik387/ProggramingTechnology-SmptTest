package org.example.services;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class MessageManager {
    private final String host = "smtp.gmail.com";
    private final String senderAddress = "kursprojecttask5fantokin@gmail.com";
    private final String senderPassword = "qqpytrfmzcjpaycn";
    private final Properties properties;
    public MessageManager(){
        properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", senderAddress);
        properties.put("mail.smtp.password", senderPassword);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    }

    public boolean sendMessage(String email, File file){
        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        try{
            message.setFrom(new InternetAddress(senderAddress));
            message.addRecipients(Message.RecipientType.TO, email);
            message.setSubject("Форматирование");

            var messageBody = new MimeBodyPart();
            messageBody.attachFile(file);

            var multipart = new MimeMultipart();
            multipart.addBodyPart(messageBody);

            message.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, senderAddress, senderPassword);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Письмо доставлено");
            return true;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
