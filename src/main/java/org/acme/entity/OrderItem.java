package org.acme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Getter @NoArgsConstructor
@ToString(callSuper = true)
@Entity @Table(name = "order_items")
public class OrderItem extends AbstractEntity {

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    public OrderItem(@NotNull Long quantity, Product product, Order order){
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    @Override
    public boolean equals(Object o){
        if ( this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(quantity, orderItem.quantity) &&
                Objects.equals(product, orderItem.product) &&
                Objects.equals(order, orderItem.order);
    }

    @Override
    public int hashCode(){
        return Objects.hash(quantity,product,order);
    }
}
