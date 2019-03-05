package com.base.core.service;

import java.io.Serializable;

/**
 *
 * @author wangxc
 * @date: 2019/3/5 下午9:38
 *
 */
public interface IService<T> {
	T save(T entity);

	T update(T entity);

	int deleteById(Serializable id);

	int getOneById(Serializable id);

}
