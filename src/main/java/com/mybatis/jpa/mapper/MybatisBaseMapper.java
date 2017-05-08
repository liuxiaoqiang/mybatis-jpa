package com.mybatis.jpa.mapper;

import java.util.List;

import com.mybatis.jpa.annotation.StatementDefinition;

/**
 * 规范通用Mapper方法签名</br>
 * 子类Mapper通过继承此接口获取方法签名,并使用{@MapperDefinition}注解标记Mapper.</br>
 * 使用{@StatementDefinition}注解标记的方法,将被解析并注入到Mybatis Statement</br>
 * 
 * about deference with insert(){@link #insert(Object)} and insertSelective()
 * {@link #insertSelective(Object)}</br>
 * 方法的区别在于null值的处理,假设column_1在数据库设置了默认值,而参数中的field_1为null值,则insert
 * 在数据库写入null,而insertSelective写入数据库默认值.
 * 
 * 
 * @author svili
 * @data 2017年5月8日
 *
 * @param <T>持久化Entity类型
 */
public interface MybatisBaseMapper<T> {

	@StatementDefinition
	int insertSelective(T t);

	@StatementDefinition
	int insert(T t);

	// @StatementDefinition
	int batchInsert(List<T> list);

	@StatementDefinition
	int deleteByPrimaryKey(Object primaryValue);

	@StatementDefinition
	int updateByPrimaryKey(T t);

	@StatementDefinition
	int updateSelectiveByPrimaryKey(T t);

	// @StatementDefinition
	int batchUpdate(T t);

	@StatementDefinition
	T selectByPrimaryKey(Object primaryValue);

	@StatementDefinition
	List<T> select();
}
