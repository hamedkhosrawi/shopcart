package org.acme.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "order")
public class Order extends AbstractEntity{

    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @NotNull
    @Enumerated
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @NotNull
    @Column(name = "shipped")
    private ZonedDateTime shipped;

    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    @Embedded
    private Address shipmentAddress;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<OrderItem> orderItems;

    @OneToOne
    private Cart cart;
}
