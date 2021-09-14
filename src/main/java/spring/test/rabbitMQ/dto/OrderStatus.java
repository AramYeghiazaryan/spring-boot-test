package spring.test.rabbitMQ.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {

    private OrderDto order;
    private String status;  //progress, completed;
    private String message;
}
