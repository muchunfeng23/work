package com.yl.work.mapper;

import com.yl.work.dto.HotConceptBeforeLastDto;
import com.yl.work.dto.paihangTable.PageInfoParam;
import com.yl.work.entity.ThsConceptEverydayEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * 数据库类型：mysql
 * 表所属schema：price_center
 * 表所属用户：root
 * 表名称：ths_concept_everyday
 * 表注释：
 * 类型：table
 * @author：denghuajie@meicai.cn
 */
@Mapper
@Component
public interface ThsConceptEverydayMapper extends BaseMapper <ThsConceptEverydayEntity,ThsConceptEverydayEntity,Integer> {
    public List<HotConceptBeforeLastDto> collectOnedayHotPoints(@Param("dayIndex") Integer dayIndex);

    public Integer maxDayIndex();

    public List<String> selectHangYePaiHang(PageInfoParam param);
    public List<ThsConceptEverydayEntity> selectHangYeDetail(@Param("newDayIndexFrom")Integer newDayIndexFrom,@Param("hangyeList")List<String> hangyeList);
}
