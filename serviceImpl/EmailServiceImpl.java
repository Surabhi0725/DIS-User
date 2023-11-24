package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import sgsits.cse.dis.user.service.EmailService;

import javax.mail.internet.MimeMessage;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender mailSender;

  @Async
  public void sendEmail(MimeMessage email) {
    mailSender.send(email);
  }
}
