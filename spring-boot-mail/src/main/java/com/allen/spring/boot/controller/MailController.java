package com.allen.spring.boot.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import com.allen.spring.boot.bean.Recipient;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public interface MailController {

	/**
	 * Send simple mail.
	 * @param recipient
	 * @return
	 */
	String sendSimpleMail(Recipient recipient);
	
	/**
	 * Send Complex mail(includes cc).
	 * @param recipient
	 * @return
	 * @throws MessagingException 
	 */
	String sendComplexMail(Recipient recipient) throws MessagingException;
	
	
	/**
	 * Send mail using template engine freemarker.
	 * @param recipient
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws MalformedTemplateNameException 
	 * @throws TemplateNotFoundException 
	 * @throws TemplateException 
	 * @throws MessagingException 
	 */
	String sendTemplateMail(Recipient recipient) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, MessagingException;
}
