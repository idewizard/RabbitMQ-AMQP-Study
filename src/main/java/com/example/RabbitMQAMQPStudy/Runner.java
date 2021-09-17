package com.example.RabbitMQAMQPStudy;

import com.example.RabbitMQAMQPStudy.MessagingRabbitmqApplication;
import com.example.RabbitMQAMQPStudy.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Enviando Mensagem!!");

        rabbitTemplate.
                convertAndSend(MessagingRabbitmqApplication.topicExchangeName,
                        "foo.bar.baz",
                        "Hello from rabiit");;
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
