package com.yl.work.mapper;

import com.yl.work.entity.ConceptAmountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**		
 * 数据库类型：mysql
 * 表所属schema：price_center
 * 表所属用户：root
 * 表名称：concept_amount
 * 表注释：
 * 类型：table
 * @author：xinli@meicai.cn
 */
@Mapper
@Component
public interface ConceptAmountMapper extends BaseMapper <ConceptAmountEntity,ConceptAmountEntity,Integer> {

}
