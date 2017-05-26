/*  
 * Copyright (c) 2004-2016 pflc.spdbccc.com.cn Inc. All rights reserved.
 * 
 * 注意：本内容仅限于上海浦东发展银行股份有限公司信用卡中心, 禁止外泄.
 * 
 */
package com.perkins.service;

import java.util.List;

import com.perkins.dao.mapper.MailSendRecordMapper;
import com.perkins.entity.MailSendRecord;

/**
 * 
 * <p><b>Description:</b> MailSendRecord服务接口
 * <p><b>Company:</b> wanda group
 * 
 * @author fangcunlei at 16:52:21 on 2017-05-12
 * @version V0.1
 */
public interface IMailSendRecordService extends IBaseService<MailSendRecord, MailSendRecordMapper>  {
	
	public MailSendRecord findMailSendRecordById(long id);
	
	public List<Long> findTasksNeedSendMail();
}