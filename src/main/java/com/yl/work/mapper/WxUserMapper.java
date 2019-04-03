package com.yl.work.mapper;

import com.yl.work.entity.WxUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**		
 * 数据库类型：mysql
 * 表所属schema：nanhang
 * 表所属用户：root
 * 表名称：wx_user
 * 表注释：
 * 类型：table
 */
@Mapper
@Component
public interface WxUserMapper extends BaseMapper <WxUserEntity,WxUserEntity,Integer> {

}
