package com.allen.spring.boot.controller.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

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

import com.allen.spring.boot.bean.Recipient;
import com.allen.spring.boot.controller.MailController;

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
    public String sendSimpleMail(@RequestBody @Valid Recipient recipient ){
    	Assert.notNull(recipient,"Assert Failed:recipient argument must not be null");
    	String mailAddress = recipient.getMailName();
    	String subject = recipient.getSubject();
    	String text = recipient.getContent();
    	SimpleMailMessage message = new SimpleMailMessage();
    	//设置发件人地址
		message.setFrom("xxxxx@qq.com");
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
		Assert.notNull(recipient,"Assert Failed:recipient argument must not be null");
		String mailAddress = recipient.getMailName();
		String subject = recipient.getSubject();
		String text = recipient.getContent();
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setFrom("xxxxxx@qq.com");
        helper.setTo(mailAddress);
        helper.setSubject(subject);
        helper.setText(text);
        //添加附件，此处是从classpath路径下拿到这个文件
        Resource file = new ClassPathResource("qq_authKey.png");
        helper.addAttachment(file.getFilename(), file);
        mailSender.send(mimeMessage);
        logger.info("Complex mail sent successfully.");
		return "Complex mail sent successfully.";
	}
}
