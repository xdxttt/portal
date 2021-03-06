package com.portal.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import com.portal.bean.OrderInfo;

/**
 * @ClassName: WorkFlowServiceImpl 
 * @Description: 工作流基础接口
 * @author Miao Wenqiang
 * @date 2016年9月17日 下午10:50:15
 */
public interface WorkFlowService {
	/**
	 * @Title: insertFlowZip 
	 * @Description: 通过zip文件部署流程
	 * @param flowFile 上传的文件
	 * @param fileName 文件名
	 * @return void
	 * @throws
	 */
	public void insertFlowZip(MultipartFile flowFile, String fileName);

	/**
	 * @Title: selectDepFlowList 
	 * @Description: 获取流程部署列表
	 * @return 
	 * @return List<Deployment>
	 * @throws
	 */
	public List<Deployment> selectDeployList();

	/**
	 * @Title: selectPdFlowList 
	 * @Description: 获取流程定义列表
	 * @return 
	 * @return List<ProcessDefinition>
	 * @throws
	 */
	public List<ProcessDefinition> selectProcessDefinitionList();

	/**
	 * @Title: selectFlowImage 
	 * @Description: 获取流程图
	 * @param deploymentId
	 * @param imageName
	 * @return 
	 * @return InputStream
	 * @throws
	 */
	public InputStream selectFlowImage(String deploymentId, String imageName);

	/**
	 * @Title: delProcessDefinitionById 
	 * @Description: 通过id，删除部署信息
	 * @param deploymentId 
	 * @return void
	 * @throws
	 */
	public void delProcessDefinitionById(String deploymentId);
	
	/**
	 * @Title: startProcess 
	 * @Description: 根据流程定义key 启动流程
	 * @param processDefinitionKey 流程定义key
	 * @param busKey 关联业务参数
	 * @param paramMap 流程参数
	 * @return void
	 * @throws
	 */
	public ProcessInstance startProcess(String processDefinitionKey, String busKey, Map<String, Object> paramMap);	
	
	/**
	 * @Title: selectTaskListById 
	 * @Description: 通过用户id 获取流程列表 
	 * @param userId
	 * @return 
	 * @return List<Task>
	 * @throws
	 */
	public List<Task> selectTaskListById(String userId, String defKey);
	
	/**
     * @Title: findOutComeListByTaskId 
     * @Description: 获取操作列表
     * @param taskId
     * @return 
     * @return List<String>
     * @throws
     */
	public List<String> findOutComeListByTaskId(String taskId);
	
	/**
     * @Title: saveSubmitTask 
     * @Description: 提交审批 
     * @param paramMap 
     * @return void
     * @throws
     */
	public void saveSubmitTask(Map<String, String> paramMap);
	
	 /**
     * @Title: findCommentByIdAndKey 
     * @Description: 根据订单id 查询历史审批信息
     * @param id
     * @return 
     * @return List<Comment>
     * @throws
     */
	public List<Comment> findCommentByIdAndKey(String id, String depKey);
	
	/**
	 * @Title: findCommentByTaskId 
	 * @Description: 根据任务id获取批注信息
	 * @param taskId
	 * @return 
	 * @return List<Comment>
	 * @throws
	 */
	public List<Comment> findCommentByTaskId(String taskId);
	
	//------------------------------- 
	/**
	 * @Title: findLatestProcessDefinitionByPrcDefKey 
	 * @Description: 根据流程定义Key查询最新流程定义.
	 * @param processDefinitionKey
	 * @return 
	 * @return ProcessDefinition
	 * @throws
	 */
	public ProcessDefinition findLatestProcessDefinitionByPrcDefKey(String processDefinitionKey);

	/**
	 * @Title: findProcessDefinitionEntityByProcDefId 
	 * @Description: 根据流程定义Id查询流程定义
	 * @param processDefinitionId
	 * @return 
	 * @return ProcessDefinitionEntity
	 * @throws
	 */
	public ProcessDefinitionEntity findProcessDefinitionEntityByProcDefId(String processDefinitionId);

	/**
	 * @Title: findProcessInstanceByProcInst 
	 * @Description: 根据流程实例Id查询流程实例
	 * @param processInstanceId
	 * @return 
	 * @return ProcessInstance
	 * @throws
	 */
	public ProcessInstance findProcessInstanceByProcInst(String processInstanceId);

	/**
	 * @Title: findExecutionByProcInst 
	 * @Description: 根据流程实例Id查询流程实例
	 * @param processInstanceId
	 * @return 
	 * @return Execution
	 * @throws
	 */
	public Execution findExecutionByProcInst(String processInstanceId);

	/**
	 * @Title: findTaskByProcInstId 
	 * @Description: 根据流程实例Id查询任务
	 * @param processInstanceId
	 * @return 
	 * @return Task
	 * @throws
	 */
	public Task findTaskByProcInstId(String processInstanceId);

	/**
	 * @Title: findTaskByExecutionId 
	 * @Description:  根据实例Id查询任务
	 * @param executionId
	 * @return 
	 * @return Task
	 * @throws
	 */
	public Task findTaskByExecutionId(String executionId);

	/**
	 * @Title: findTaskDefinitionByActivityImpl 
	 * @Description:  根据活动节点查询任务定义
	 * @param activityImpl
	 * @return 
	 * @return TaskDefinition
	 * @throws
	 */
	public TaskDefinition findTaskDefinitionByActivityImpl(ActivityImpl activityImpl);

	/**
	 * @Title: beforeTaskDefinition 
	 * @Description: 查询上一个节点
	 * @param activityImpl
	 * @param activityId
	 * @param elString
	 * @return 
	 * @return TaskDefinition
	 * @throws
	 */
	public TaskDefinition beforeTaskDefinition(ActivityImpl activityImpl, String activityId, String elString);

	/**
	 * @Title: nextTaskDefinition 
	 * @Description: 查询下一个节点
	 * @param activityImpl
	 * @param activityId
	 * @param elString
	 * @return 
	 * @return TaskDefinition
	 * @throws
	 */
	public TaskDefinition nextTaskDefinition(ActivityImpl activityImpl, String activityId, String elString);

	/**
	 * @Title: findPvmActivity 
	 * @Description: 根据活动节点、活动线路查询线路的连接线
	 * @param activityImpl
	 * @param transitions
	 * @return 
	 * @return PvmActivity
	 * @throws
	 */
	public PvmActivity findPvmActivity(ActivityImpl activityImpl, String transitions);

	/**
	 * @Title: findTaskDefinition 
	 * @Description: 根据流程定义Id查询任务定义
	 * @param processDefinitionId
	 * @return 
	 * @return TaskDefinition
	 * @throws
	 */
	public TaskDefinition findTaskDefinition(String processDefinitionId);

	/**
	 * @Title: addTaskComment 
	 * @Description: 添加任务意见
	 * @param taskId
	 * @param processInstanceId
	 * @param comment 
	 * @return void
	 * @throws
	 */
	public void addTaskComment(String taskId, String processInstanceId, String comment);

	/**
	 * @Title: claimTask 
	 * @Description: 拾取任务
	 * @param taskId
	 * @param operator 
	 * @return void
	 * @throws
	 */
	public void claimTask(String taskId, String operator);

	/**
	 * @Title: findProcessDefinitionByPrcDefId 
	 * @Description: 根据流程定义Id查询最新流程定义
	 * @param processDefinitionId
	 * @return 
	 * @return ProcessDefinition
	 * @throws
	 */
	public ProcessDefinition findProcessDefinitionByPrcDefId(String processDefinitionId);

	/**
	 * @Title: selectlerkEverydayAchievenment 
	 * @Description: 员工每日业绩查看
	 * @param paramMap
	 * @return 
	 * @return Map<String, Object>
	 * @throws
	 */
	public Map<String, Object> selectlerkEverydayAchievenment(Map<String, Object> paramMap);

	/**
	 * @Title: selectPhoneStaffName 
	 * @Description: 获取电联人员
	 * @param phoneStaffIds
	 * @return 
	 * @return String
	 * @throws
	 */
	public String selectPhoneStaffName(String[] phoneStaffIds);

	/**
	 * @Title: selectClerkReceiveList 
	 * @Description: 业务员每日接待信息
	 * @param paramMap
	 * @return 
	 * @return List<OrderInfo>
	 * @throws
	 */
	public List<Map<String, Object>> selectClerkReceiveList(Map<String, Object> paramMap);

	/**
	 * @Title: selectClerkReceiveList 
	 * @Description: 业务员每日接待数量
	 * @param paramMap
	 * @return 
	 * @return List<OrderInfo>
	 * @throws
	 */
	public int selectClerkReceiveCount(Map<String, Object> paramMap);

	/**
	 * @Title: selectTaskCountById 
	 * @Description: 获取当前人员执行任务数量
	 * @param userId
	 * @param defKey
	 * @return int
	 * @throws
	 */
	public int selectTaskCountById(String userId, String defKey);

	/**
	 * @Title: selectTaskCountById 
	 * @Description: 获取业务员每日的业绩列表
	 * @param paramMap
	 * @return List<Map<String, Object>>
	 * @throws
	 */
	public List<Map<String, Object>> selectClerkDayList(Map<String, Object> paramMap);

	/**
	 * @Title: selectCivilizationOrderList 
	 * @Description: 文交所订单列表
	 * @param paramMap
	 * @return 
	 * @return List<Map<String,Object>>
	 * @throws
	 */
	public List<Map<String, Object>> selectCivilizationOrderList(Map<String, Object> paramMap);

	/**
	 * @Title: selectCivilizationOrderCount 
	 * @Description: 文交所订单列表数量
	 * @param paramMap
	 * @return 
	 * @return int
	 * @throws
	 */
	public int selectCivilizationOrderCount(Map<String, Object> paramMap);

	/**
	 * @param paramMap 
	 * @Title: getAccountAndPayTypeInfo 
	 * @Description: 获取支付方式和账户列表
	 * @return 
	 * @return Map<String,Object>
	 * @throws
	 */
	public Map<String, Object> getAccountAndPayTypeInfo(Map<String, Object> paramMap);

	/**
	 * @Title: getAuditorId 
	 * @Description: 通过用户id 获取领导id
	 * @param userId
	 * @return String
	 * @throws
	 */
	public String getAuditorId(String userId);

}
