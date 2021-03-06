/**
The MIT License (MIT) * Copyright (c) 2017 铭飞科技

 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */package com.mingsoft.weixin.event.impl;

import java.util.Map;

import com.mingsoft.weixin.entity.WeixinPeopleEntity;
import com.mingsoft.weixin.event.IWeixinEventHandler;

/**
 * 铭飞科技流量推广软件
 * Copyright: Copyright (c) 2013 - 2015
 * Company:景德镇铭飞科技有限公司
 * @author killfen
 * @version 100-000-000
 * 版权所有
 * Comments:用户取消关注
 * Create Date:2014-3-11
 * Modification history:暂无
 */
public class UnSubscribeEventHandler extends IWeixinEventHandler {
	
	public Map<String, Object> execute(Map<String, Object> params) {
		init(params);
		if (null != msgType && msgType.equals(EVENT) && event.equals(EVENT_UNSUBSCRIBE)) {
			updatePeopleState();
			logger.debug("执行取消关注");
		} 
		return null;
	}

	/**
	 * 改变用户的关注状态
	 */
	private void updatePeopleState(){
		WeixinPeopleEntity weixinPeople = new WeixinPeopleEntity();
		weixinPeople.setWeixinPeopleOpenId(this.fromUserName);
		weixinPeople.setWeixinPeopleState(WeixinPeopleEntity.WEIXIN_PEOPLE_CANCEL_WATCH);
		this.weixinPeopleBiz.updatePeople(weixinPeople);
	}
}
