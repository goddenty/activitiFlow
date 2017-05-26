/*  
 * Copyright (c) 2004-2016 pflc.spdbccc.com.cn Inc. All rights reserved.
 * 
 * 注意：本内容仅限于太平洋保险有限公司, 禁止外泄.
 * 
 */
package com.perkins.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * <p><b>Description:</b> MailSendRecord实体类
 * <p><b>Company:</b> wandagroup
 * 
 * @author created by fangcunlei at 16:52:21 on 2017-05-12
 * @version V0.1
 */
@Table(name = "TBYB_MAIL_SEND_RECORD")
public class MailSendRecord extends IDEntity {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="Mysql")
	private Long id;
	
	//taskId 
	@Column(name = "TASK_ID")
	private Long taskId;
	
	//receiver 
	@Column(name = "RECEIVER")
	private String receiver;
	
	//mailStatus 
	@Column(name = "MAIL_STATUS")
	private String mailStatus;
	
	//mailContent 
	@Column(name = "MAIL_CONTENT")
	private String mailContent;
	
	//mailTitile 
	@Column(name = "MAIL_TITILE")
	private String mailTitile;
	
	@Column(name = "DELETED")
	private String deleted;
	
	/**
	 * 设置taskId的值
	 * @param taskId taskId
	 */
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	/**
	 * 获取taskId的值
	 * @return taskId
	 */
	public Long getTaskId() {
		return this.taskId;
	}
	/**
	 * 设置receiver的值
	 * @param receiver receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	/**
	 * 获取receiver的值
	 * @return receiver
	 */
	public String getReceiver() {
		return this.receiver;
	}
	/**
	 * 设置mailStatus的值
	 * @param mailStatus mailStatus
	 */
	public void setMailStatus(String mailStatus) {
		this.mailStatus = mailStatus;
	}
	/**
	 * 获取mailStatus的值
	 * @return mailStatus
	 */
	public String getMailStatus() {
		return this.mailStatus;
	}
	/**
	 * 设置mailContent的值
	 * @param mailContent mailContent
	 */
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	/**
	 * 获取mailContent的值
	 * @return mailContent
	 */
	public String getMailContent() {
		return this.mailContent;
	}
	/**
	 * 设置mailTitile的值
	 * @param mailTitile mailTitile
	 */
	public void setMailTitile(String mailTitile) {
		this.mailTitile = mailTitile;
	}
	/**
	 * 获取mailTitile的值
	 * @return mailTitile
	 */
	public String getMailTitile() {
		return this.mailTitile;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDeleted() {
		return deleted;
	}
	
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
}
