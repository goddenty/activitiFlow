package com.perkins.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Before;
import org.junit.Test;

public class CaigouProcess {
	
	ProcessEngineConfiguration engine=null;
	
	@Before
	public void createProcessEngine(){
		engine=ProcessEngineConfiguration.
				createStandaloneProcessEngineConfiguration();
		engine.setJdbcDriver("com.mysql.jdbc.Driver");
		engine.setJdbcUrl("jdbc:mysql://localhost:3306/activitiDB?createDatabaseIfNotExist=true"
				+"&useUnicode=true&characterEncoding=utf8");
		engine.setJdbcUsername("root");
		engine.setJdbcPassword("fcl821121");
		engine.setDatabaseSchemaUpdate("true");
		engine.buildProcessEngine();
	}
	
	//部署流程定义
		@Test
		public void deploy(){
			//取得流程引擎对象
//			ProcessEngine processEngine=ProcessEngines.getDefaultProcessEngine();
			//获取仓库服务 ：管理流程定义
			RepositoryService repositoryService = engine.getRepositoryService();
			Deployment deploy = repositoryService.createDeployment()//创建一个部署的构建器
			.addClasspathResource("config/diagram/subProcessTest.bpmn")//从类路径中添加资源,一次只能添加一个资源
			.addClasspathResource("config/diagram/subProcessTest.png")//从类路径中添加资源,一次只能添加一个资源
			.name("采购单流程")//设置部署的名称
			.category("办公类别")//设置部署的类别
			.deploy();
			
			System.out.println("部署的id"+deploy.getId());
			System.out.println("部署的名称"+deploy.getName());
			
		}
		//执行流程
		@Test
		public void startProcess(){
			String processDefiKey="caigouProcess";
			//取运行时服务
			RuntimeService runtimeService = engine.getRuntimeService();
			//取得流程实例
			ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefiKey);//通过流程定义的key 来执行流程
			System.out.println("流程实例id:"+pi.getId());//流程实例id
			System.out.println("流程定义id:"+pi.getProcessDefinitionId());//输出流程定义的id
		}
		
		//查询任务 
		@Test
		public void queryTask(){
			//任务的办理人
			String assignee="王国强";
			//取得任务服务
			TaskService taskService = engine.getTaskService();
			//创建一个任务查询对象
			TaskQuery taskQuery = taskService.createTaskQuery();
			//办理人的任务列表
			List<Task> list = taskQuery.taskAssignee(assignee)//指定办理人
			.list();
			
			//遍历任务列表
			if(list!=null&&list.size()>0){
				for(Task task:list){
					System.out.println("任务的办理人："+task.getAssignee());
					System.out.println("任务的id："+task.getId());
					System.out.println("任务的名称："+task.getName());
					
				}
			}
			
		}
		
		//转任务
				@Test
				public void transferTask(){
					String taskId="22504";
					//taskId：任务id
					Map<String,Object> map =new HashMap<String,Object>();
					map.put("amount", 5000);
					engine.getTaskService().setAssignee(taskId, "刘博");
					System.out.println("当前任务执行完毕");
				}
		
		//完成任务
		@Test
		public void compileTask(){
			String taskId="25003";
			//taskId：任务id
			Map<String,Object> map =new HashMap<String,Object>();
			map.put("amount", 500000);
			map.put("result", "rejected");
			engine.getTaskService().complete(taskId,map);
			System.out.println("当前任务执行完毕");
		}
}
