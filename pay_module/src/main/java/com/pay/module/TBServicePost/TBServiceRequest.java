package com.pay.module.TBServicePost;

import javax.xml.ws.ServiceMode;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pay.basic.utils.DateUtils;
import com.pay.component.socket.ClientSocket;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TBServiceRequest {

	public String send(String requestData) {
		String responseDate = "Error|00000000|成功|" + DateUtils.getTradeDate() + "|PB500099|银行交易处理中|";
		try {
			log.info("tbService发送报文:" + requestData);
			responseDate = ClientSocket.send(requestData);
			log.info("tbService返回报文:" + responseDate);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return responseDate;
	}
}
