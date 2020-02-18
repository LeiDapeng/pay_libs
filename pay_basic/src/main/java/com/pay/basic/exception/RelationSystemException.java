package com.pay.basic.exception;

import com.pay.basic.exception.enums.RelationSystemExceptionTypeEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 
 * @Title: CommunicationException.java
 * @Description: 系统异常处理类
 * @author: 雷大鹏
 * @date: 2020-02-03 05:58:39
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class RelationSystemException extends RuntimeException {
	// 通讯类型
	private RelationSystemExceptionTypeEnum exceptionTypeEnum;
	// 错误描述
	private String errorMsg;
}
