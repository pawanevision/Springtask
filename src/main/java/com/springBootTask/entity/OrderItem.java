package com.springBootTask.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "order_itemDetail")
public class OrderItem {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long itemId;

    @Column(name = "item_Name")
    private String itemName;

    @Column(name = "item_Price")
    private long itemPrice;

    @Column(name = "item_quantity")
    private Integer quantity;

    public void setOrder(Order existingOrder) {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",insertable=false, updatable=false)
    private Order order;






}
