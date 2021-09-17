package com.example.RabbitMQAMQPStudy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch countDownLatch = new CountDownLatch(1);


    public void receiveMessage(String message){
        System.out.printf("Recebido:< %s >",message);
        countDownLatch.countDown();
    }

    public CountDownLatch getLatch(){
        return countDownLatch;
    }
}
