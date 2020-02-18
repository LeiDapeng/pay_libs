package com.pay.basic.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @Title: CommunicationExceptionTypeEnum.java
 * @Description: 内部逻辑处理异常类型枚举
 * @author: 雷大鹏
 * @date: 2020-02-03 06:37:55
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public enum DefaultExceptionTypeEnum {
	DEFAULT("未知异常");

	@Setter
	@Getter
	private String exceptionType;
}
