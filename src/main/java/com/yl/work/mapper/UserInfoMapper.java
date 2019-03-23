package com.yl.work.mapper;

import com.yl.work.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**		
 * 数据库类型：mysql
 * 表所属schema：nanhang
 * 表所属用户：root
 * 表名称：user_info
 * 表注释：
 * 类型：table
 * @author：xinli@meicai.cn
 */
@Mapper
@Component
public interface UserInfoMapper extends BaseMapper <UserInfoEntity,UserInfoEntity,Integer> {

}
