package com.yl.work.mapper;
import java.util.List;
import java.util.LinkedHashMap;
import org.apache.ibatis.annotations.Param;
/**
 * @param <T>
 * @param <ID>
 */
public interface BaseMapper<T,P,ID> {
	public T getById(ID id);
	public List<T> getByIds(List<ID> ids);
	public Integer selectCount(@Param("tb") T t);
	public List<T> select(@Param("tb") T t, @Param("sort") LinkedHashMap<String, String> sort, @Param("offset") Integer offset, @Param("limit") Integer limit);

	public Integer insert(T t);
	public Integer insertNotNull(T t);
	public Integer insertBatch(List<T> list);

	public Integer updateById(@Param("tb") T t, @Param("id") ID id);

	public Integer delete(T t);
	public Integer deleteById(ID id);
	public Integer deleteByIds(List<ID> list);
}