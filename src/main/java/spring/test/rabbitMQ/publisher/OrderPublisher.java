package spring.test.rabbitMQ.publisher;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.test.rabbitMQ.dto.OrderDto;
import spring.test.rabbitMQ.dto.OrderStatus;
import spring.test.rabbitMQ.utils.Constants;
import spring.test.rabbitMQ.utils.Statuses;

import java.text.MessageFormat;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderPublisher {

    private RabbitTemplate template;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bookOrder(@RequestBody OrderDto order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, Statuses.PROGRESS, "Order placed successfully");

        template.convertAndSend(Constants.EXCHANGE, Constants.BINDING_KEY, orderStatus);

        System.out.println(MessageFormat.format("Order Published Successfully: {0}", orderStatus));
        return ResponseEntity.ok("Success");
    }

}
