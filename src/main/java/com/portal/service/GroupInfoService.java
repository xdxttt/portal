package com.portal.service;

import com.portal.bean.Criteria;
import com.portal.bean.GroupInfo;
import java.util.List;

public interface GroupInfoService {
    int countByExample(Criteria example);

    GroupInfo selectByPrimaryKey(String id);

    List<GroupInfo> selectByExample(Criteria example);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GroupInfo record);

    int updateByPrimaryKey(GroupInfo record);

    int deleteByExample(Criteria example);

    int updateByExampleSelective(GroupInfo record, Criteria example);

    int updateByExample(GroupInfo record, Criteria example);

    int insert(GroupInfo record);

    int insertSelective(GroupInfo record);
    
    /**
     * @Title: getAllCompany 
     * @Description: 获取所有机构(公司)
     * @return List<GroupInfo>
     * @author Xia ZhengWei
     * @date 2016年12月25日 下午6:14:03 
     * @version V1.0
     */
    List<GroupInfo> getAllCompany();
}