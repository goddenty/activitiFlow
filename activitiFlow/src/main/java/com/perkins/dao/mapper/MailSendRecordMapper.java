/*  
 * Copyright (c) 2004-2016 pflc.spdbccc.com.cn Inc. All rights reserved.
 * 
 * 注意：本内容仅限于上海浦东发展银行股份有限公司信用卡中心, 禁止外泄.
 * 
 */
package com.perkins.dao.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.perkins.entity.MailSendRecord;

/**
 * 
 * <p><b>Description:</b> MailSendRecordMapper
 * <p><b>Company:</b> wandasgroup
 * 
 * @author created by fangcunlei at 16:52:21 on 2017-05-12
 * @version V0.1
 */
public interface MailSendRecordMapper extends Mapper<MailSendRecord> {
	
	public MailSendRecord findMailSendRecordById(long id);
	
	public List<Long> findTasksNeedSendMail();
}