package com.springBootTask.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItemDTO {
    private long itemId;
    private String itemName;
    private double itemPrice;
    private int quantity;
    private Long orderId;
 


}

