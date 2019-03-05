package com.base.core.service.impl;

import com.base.core.dao.BaseMapper;
import com.base.core.service.IService;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 *
 * @author wangxc
 * @date: 2019/3/5 下午9:48
 *
 */
public class ServiceImpl<M extends BaseMapper<T>,T> implements IService<T> {

	@Resource
	protected M baseMapper;

	public T save(T entity) {
		return baseMapper.save(entity);
	}

	public T update(T entity) {
		return baseMapper.update(entity);
	}

	public int deleteById(Serializable id) {
		return baseMapper.deleteById(id);
	}

	public int getOneById(Serializable id) {
		return baseMapper.getOneById(id);
	}
}
