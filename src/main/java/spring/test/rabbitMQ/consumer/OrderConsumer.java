package spring.test.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import spring.test.rabbitMQ.dto.OrderStatus;

@Component
public class OrderConsumer {

    @RabbitListener(queues = "my_first_queue")
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println(orderStatus);
    }

}
