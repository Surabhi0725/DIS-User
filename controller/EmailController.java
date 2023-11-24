package sgsits.cse.dis.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import sgsits.cse.dis.user.constants.DisConstants;
import sgsits.cse.dis.user.feignClient.TaskAttachment;
import sgsits.cse.dis.user.model.EventAttachment;
import sgsits.cse.dis.user.service.EmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.util.Set;

@Controller
@EnableAsync
public class EmailController {

  @Autowired
  private EmailService emailService;

  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private TaskAttachment taskAttachment;
  @Async
  public void sendSimpleEmail(String subject, String text, Set<EventAttachment> attachments,
          String... cclist) throws MessagingException, UnknownHostException, SQLException {
    // Create a Simple MailMessage.
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true);
    helper.setFrom(DisConstants.DIS_EMAIL);
    helper.setCc(cclist);
    helper.setSubject(subject);
    helper.setText(text);
    if (attachments != null) {
      if (!attachments.isEmpty()) {
        for (EventAttachment attachment : attachments) {
          Resource file = (Resource) taskAttachment.getFile(attachment.getFileUrl());
          helper.addAttachment(attachment.getFileName(),
                  (File)file
          );
        }
      }
    }
    emailService.sendEmail(message);
  }
}