/*  
 * Copyright (c) 2004-2016 pflc.spdbccc.com.cn Inc. All rights reserved.
 * 
 * 娉ㄦ剰锛氭湰鍐呭浠呴檺浜庝笂娴锋郸涓滃彂灞曢摱琛岃偂浠芥湁闄愬叕鍙镐俊鐢ㄥ崱涓績, 绂佹澶栨硠.
 * 
 */
package com.perkins.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.perkins.dao.mapper.MailSendRecordMapper;
import com.perkins.entity.MailSendRecord;
import com.perkins.service.IMailSendRecordService;

/**
 * 
 * <p><b>Description:</b> MailSendRecord鏈嶅姟瀹炵幇绫�
 * <p><b>Company:</b> wandagroup
 * 
 * @author created by fangcunlei at 16:52:21 on 2017-05-12
 * @version V0.1
 */
@Service
public class MailSendRecordService extends BaseService<MailSendRecord, MailSendRecordMapper> implements IMailSendRecordService{
	
	public MailSendRecord findMailSendRecordById(long id){
        return this.mapper.findMailSendRecordById(id);
    }
	
	public List<Long> findTasksNeedSendMail(){
		return this.mapper.findTasksNeedSendMail();
	}
	
	public void sendMail(){
		MailSendRecord record=new MailSendRecord();
		record.setMailContent("秦时明月汉时关，万里长征人未还");
		record.setMailTitile("诗歌拾遗");
		record.setReceiver("fangcunlei@126.com");
		this.mapper.insert(record);
	}
	
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
		MailSendRecordService service=app.getBean(MailSendRecordService.class);
		service.sendMail();
	}
}