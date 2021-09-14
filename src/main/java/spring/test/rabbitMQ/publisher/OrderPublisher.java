package spring.test.rabbitMQ.publisher;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.test.rabbitMQ.dto.OrderDto;
import spring.test.rabbitMQ.dto.OrderStatus;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderPublisher {

    private RabbitTemplate template;

    @PostMapping(value = "/{restaurantName}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String bookOrder(@RequestBody OrderDto order, @PathVariable("restaurantName") String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "Process", "Order placed successfully");
        template.convertAndSend("my_first_exchange", "my_key", orderStatus);
        return "Success";
    }

}
