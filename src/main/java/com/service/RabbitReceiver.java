package com.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.Barista;
import com.domain.Product;

@Component
public class RabbitReceiver {

    @StreamListener(Barista.INPUT_CHANNEL)
	//对于那些有返回数据的方法，必须使用@SendTo注解来指定返回数据的输出绑定目标。
  	@SendTo(Barista.NETSHOES_PRODUCTS)
    public Product receiver(Message<Product> message){
    	Product obj = message.getPayload();
        System.out.println("接受对象:" + obj);
        return obj;
    }

    //定义在方法上，作用是将被修饰的方法注册为消息中间件上数据流的事件监听器，注解中的属性值对应了监听的消息通道名。
    @StreamListener(Barista.NETSHOES_PRODUCTS)
	public void netshoesProducts(Product product) {
    	System.out.println("接受对象2:" + product);
	}

}