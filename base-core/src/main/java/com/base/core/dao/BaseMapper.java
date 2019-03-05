package com.base.core.dao;

import java.io.Serializable;

/**
 *
 * @author wangxc
 * @date: 2019/3/5 下午10:02
 *
 */
public interface BaseMapper<T> {
	T save(T entity);

	T update(T entity);

	int deleteById(Serializable id);

	int getOneById(Serializable id);
}
