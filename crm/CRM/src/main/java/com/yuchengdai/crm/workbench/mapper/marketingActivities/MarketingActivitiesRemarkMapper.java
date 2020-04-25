package com.yuchengdai.crm.workbench.mapper.marketingActivities;

import com.yuchengdai.crm.workbench.domain.MarketingActivitiesRemark;

import java.util.List;

public interface MarketingActivitiesRemarkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_marketing_activities_remark
     *
     * @mbg.generated Fri Mar 13 15:42:01 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_marketing_activities_remark
     *
     * @mbg.generated Fri Mar 13 15:42:01 CST 2020
     */
    int insert(MarketingActivitiesRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_marketing_activities_remark
     *
     * @mbg.generated Fri Mar 13 15:42:01 CST 2020
     */
    int insertSelective(MarketingActivitiesRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_marketing_activities_remark
     *
     * @mbg.generated Fri Mar 13 15:42:01 CST 2020
     */
    MarketingActivitiesRemark selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_marketing_activities_remark
     *
     * @mbg.generated Fri Mar 13 15:42:01 CST 2020
     */
    int updateByPrimaryKeySelective(MarketingActivitiesRemark record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_marketing_activities_remark
     *
     * @mbg.generated Fri Mar 13 15:42:01 CST 2020
     */
    int updateByPrimaryKey(MarketingActivitiesRemark record);

    //通过activity_id查询出对应市场活动备注信息集合，创建人和修改人通过id联合user表查询获取对应name
    List<MarketingActivitiesRemark> selectMarketingActivitiesRemarkForDetailByActivityId(String activityId);

    //通过市场活动id，activity_id删除市场活动备注信息
    int deleteMarketingActivitiesRemarkByActivityId(String[] ids);

    //添加市场活动备注信息
    int insertMarketingActivitiesRemark(MarketingActivitiesRemark marketingActivitiesRemark);

    //根据id查询市场活动备注信息
    //前端可以通过jsp页面直接获取信息，暂停使用
    /*MarketingActivitiesRemark selectMarketingActivitiesnoteContentById(String id);*/

    //根据id更新市场活动备注信息
    int updateMarketingActivitiesRemark(MarketingActivitiesRemark marketingActivitiesRemark);

    //根据id删除市场活动备注信息
    int deleteMarketingActivitiesRemarkById(String id);
}