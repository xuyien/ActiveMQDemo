package com.testActive;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
@Service(value="consumerImpl")
public class consumerImpl implements consumer {
	@Resource(name="menuTemplate")
	private JmsTemplate tmp;//ע��ģ�壺��ȡ���������ӣ��Ȳ���

	public TextMessage getMessage(Destination dest) {
		return(TextMessage) tmp.receive();		
	}

}
