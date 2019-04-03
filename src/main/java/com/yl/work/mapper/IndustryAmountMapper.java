package com.yl.work.mapper;

import com.yl.work.entity.IndustryAmountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**		
 * 数据库类型：mysql
 * 表所属schema：price_center
 * 表所属用户：root
 * 表名称：industry_amount
 * 表注释：
 * 类型：table
 */
@Mapper
@Component
public interface IndustryAmountMapper extends BaseMapper <IndustryAmountEntity,IndustryAmountEntity,Integer> {
}
