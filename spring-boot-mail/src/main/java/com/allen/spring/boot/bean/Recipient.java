/**
 * 
 */
package com.allen.spring.boot.bean;

/**
 * @author meng
 *
 */
public class Recipient {

	// 收件人地址
	private String mailName;

	// 邮件主题
	private String subject;

	// 邮件内容
	private String content;

	public String getMailName() {
		return mailName;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
