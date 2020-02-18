package com.pay.basic.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @Title: CommunicationExceptionTypeEnum.java
 * @Description: 关联系统处理异常类型枚举
 * @author: 雷大鹏
 * @date: 2020-02-03 06:37:55
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public enum RelationSystemExceptionTypeEnum {
	LJJZ("逻辑集中"), KHXX("客户信息平台"),MG("密管平台");

	@Setter
	@Getter
	private String exceptionType;
}
