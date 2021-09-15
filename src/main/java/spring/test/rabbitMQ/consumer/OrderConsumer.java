package spring.test.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import spring.test.rabbitMQ.dto.OrderStatus;
import spring.test.rabbitMQ.utils.Constants;

import java.text.MessageFormat;

@Component
public class OrderConsumer {

    @RabbitListener(queues = Constants.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println(MessageFormat.format("Order Consumed Successfully: {0}", orderStatus));
    }

}
