package com.allen.spring.boot.controller.impl;

import com.allen.spring.boot.bean.Employee;
import com.allen.spring.boot.bean.Recipient;
import com.allen.spring.boot.controller.MailController;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by meng on 2018/8/4.
 */
@RestController
public class MailControllerImpl implements MailController {

    private static Logger logger = LoggerFactory.getLogger(MailControllerImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping(path = "/simpleMail")
    @Override
    public String sendSimpleMail(@RequestBody @Valid Recipient recipient) {
        Assert.notNull(recipient, "Assert Failed:recipient argument must not be null");
        String mailAddress = recipient.getMailName();
        String subject = recipient.getSubject();
        String text = recipient.getContent();
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置发件人地址,此处需要跟application.properties中的spring.mail.username保持一致
        message.setFrom("xxx@qq.com");
        message.setTo(mailAddress);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        logger.info("Simple mail sent successfully.");
        return "Simple mail sent successfully.";
    }

    @PostMapping(path = "/complexMail")
    @Override
    public String sendComplexMail(@RequestBody @Valid Recipient recipient) throws MessagingException {
        Assert.notNull(recipient, "Assert Failed:recipient argument must not be null");
        String mailAddress = recipient.getMailName();
        String subject = recipient.getSubject();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // 设置发件人地址,此处需要跟application.properties中的spring.mail.username保持一致
        helper.setFrom("xxx@qq.com");
        helper.setTo(mailAddress);
        helper.setSubject(subject);
        // 嵌入静态资源
        helper.setText("<html><body><img src=\"cid:peppa\" ></body></html>", true);
        Resource peppa = new ClassPathResource("images/peppa.jpg");
        // 此处的"peppa"与静态页面中的"cid:peppa"相对应
        helper.addInline("peppa", peppa);

        // 添加附件，此处是从classpath路径下拿到这个文件
        Resource file = new ClassPathResource("images/qq_authKey.png");
        helper.addAttachment(file.getFilename(), file);

        mailSender.send(mimeMessage);
        logger.info("Complex mail sent successfully.");
        return "Complex mail sent successfully.";
    }

    @PostMapping(path = "/templateMail")
    @Override
    public String sendTemplateMail(@RequestBody Recipient recipient) throws TemplateNotFoundException,
            MalformedTemplateNameException, ParseException, IOException, TemplateException, MessagingException {
        Assert.notNull(recipient, "Assert Failed:recipient argument must not be null");
        String mailAddress = recipient.getMailName();
        String subject = recipient.getSubject();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        mimeMessage.addRecipients(Message.RecipientType.TO, mailAddress);
        // 设置发件人地址,此处需要跟application.properties中的spring.mail.username保持一致
        mimeMessage.setFrom("xxx@qq.com");
        mimeMessage.setSubject(subject);

        MimeMultipart mixed = new MimeMultipart("mixed");
        mimeMessage.setContent(mixed);
        MimeBodyPart content = new MimeBodyPart();
        mixed.addBodyPart(content);

        MimeMultipart bodyMimeMultipart = new MimeMultipart("related");
        content.setContent(bodyMimeMultipart);
        MimeBodyPart bodyPart = new MimeBodyPart();

        StringWriter out = loadFtl();
        
        bodyPart.setContent(out.toString(),"text/html;charset=utf-8");
        bodyMimeMultipart.addBodyPart(bodyPart);
        mimeMessage.saveChanges();
        
        mailSender.send(mimeMessage);
        return "Template mail sent successfully.";
    }

    private StringWriter loadFtl() throws TemplateException, IOException {
        Employee employee = new Employee("Allen", 25 , "male" ,new Date(),"China","13588888888");
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setClassLoaderForTemplateLoading(ClassLoader.getSystemClassLoader(), "/");
        Template emailTemplate = cfg.getTemplate("mailTemplate.ftl");
        StringWriter out = new StringWriter();
        emailTemplate.process(employee, out);
        return out;
    }
}
