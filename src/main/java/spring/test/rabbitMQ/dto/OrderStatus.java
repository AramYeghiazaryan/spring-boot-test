package spring.test.rabbitMQ.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.test.rabbitMQ.utils.Statuses;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {

    private OrderDto order;
    private Statuses status;  //progress, completed;
    private String message;
}
