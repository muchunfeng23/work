package com.yl.work.mapper;

import com.yl.work.entity.IndustryAmountEntity;
import com.yl.work.shares.bean.IndustryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
/**		
 * 数据库类型：mysql
 * 表所属schema：price_center
 * 表所属用户：root
 * 表名称：industry_amount
 * 表注释：
 * 类型：table
 */

/**
 * 行业信息
 */
@Mapper
@Component
public interface IndustryAmountMapper extends BaseMapper <IndustryAmountEntity,IndustryAmountEntity,Integer> {
    public List<IndustryInfo> queryIndustryInfos(@Param("datekey")Integer fromDatekey,@Param("descAsc")String descAsc);
}
