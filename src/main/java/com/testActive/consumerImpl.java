package com.testActive;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
@Service(value="consumerImpl")
public class consumerImpl implements consumer {
	@Resource(name="menuTemplate")
	private JmsTemplate tmp;//注入模板：获取工厂，连接，等操作

	public TextMessage getMessage(Destination dest) {
		return(TextMessage) tmp.receive();		
	}

}
