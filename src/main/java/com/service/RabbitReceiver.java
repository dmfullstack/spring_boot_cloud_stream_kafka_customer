package com.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.Barista;
import com.domain.Product;

@Component
public class RabbitReceiver {

	//定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性值对应了监听的消息通道名。
    @StreamListener(Barista.INPUT_CHANNEL)
	//很多时候在处理完输入消息后，需要反馈一个消息给对方，这时可以通过@SendTo注解来指定返回内容的输出通道
  	@SendTo(Barista.OUTPUT_CHANNEL)
    public Product receiver(Message<Product> message){
    	Product obj = message.getPayload();
        System.out.println("接受对象:" + obj);
        obj.setSku("2");
        return obj;
    }

}