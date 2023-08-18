package com.springBootTask.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Order_detail")
public class Order {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long orderId;

    @Column(name = "Order_Type")
    private String orderType;
    @Column(name = "Order_Person_Name")
    private String orderPersonName;
    @Column(name = "Order_Destination_Place")
    private String orderDestinationPlace;
    @Column(name = "Order_DispatchedDate")
    private String orderdispatchDate;
    @Column(name = "Order_Source_Place")
    private  String orderSourcePlace;

    @OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId",updatable = false,nullable = false)
    private Set<OrderItem> orderItemList;


    @Column(name = "order_status")
    private String status;


    @Column(name = "order_deliver_date")
    @UpdateTimestamp
    private LocalDate date;



}
