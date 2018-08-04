package com.allen.spring.boot.controller;

import javax.mail.MessagingException;

import com.allen.spring.boot.bean.Recipient;

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
}
