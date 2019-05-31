package com.base.core.controller;

import com.base.core.reqres.response.BaseResp;
import com.base.core.reqres.response.ResultStatus;

/**
 *
 * @author wangxc
 * @date: 2019/3/5 下午11:15
 *
 */
public class BaseController {

	protected static BaseResp<?> SUCCESS_TIP = new BaseResp<>(ResultStatus.SUCCESS);
}
