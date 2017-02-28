package com.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.Barista;
import com.domain.Product;

@Component
public class RabbitReceiver {

    @StreamListener(Barista.INPUT_CHANNEL)
    public void receiver(Message<Product> message){
    	Product obj = message.getPayload();
        System.out.println("接受对象:" + obj);
    }

}