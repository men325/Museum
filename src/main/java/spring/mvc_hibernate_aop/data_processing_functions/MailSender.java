package spring.mvc_hibernate_aop.data_processing_functions;


import spring.mvc_hibernate_aop.entity.Excursion;
import spring.mvc_hibernate_aop.entity.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {


    public static void sendEmail(User user, Excursion excursion) {
        // Куда отправляем
        //String to = "x4playerx4@ukr.net";
        String to = user.getUser_email();

        // Откуда отправляем
        String from = "x4playerx4@gmail.com";
        final String username = "x4playerx4";//username
        final String password = "zjbbrgyuzslfdmcx"; // zjbbrgyuzslfdmcx


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Вітаємо," + user.getUser_full_name() + " !");          ///ЗАГОЛОВОК ПИСЬМА

            // Now set the actual message
            String s1 = "Очікуємо Вас у нашому музеї, " + excursion.getMuseum().getMuseum_name() + "\n";
            String s2 = "Ви обрали екскурсію: " + excursion.getExcursion_name() + "\n";
            String s3 = "Дата екскурсії: " + excursion.getExcursion_date() + "\n";
            String s4 = "Часи екскурсії: з " + excursion.getExcursion_start_time() + " до " + excursion.getExcursion_end_time() + "\n";
            String s5 = "Ваш гід: " + excursion.getGuide().getGuide_full_name() + ". Телефон гіда: " + excursion.getGuide().getGuide_phone_number() + "\n";
            String s6 = "До зустрічі на екскурсії, " + user.getUser_full_name() + "!" + "\n";
            message.setText(s1 + s2 + s3 + s4 + s5 + s6);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
