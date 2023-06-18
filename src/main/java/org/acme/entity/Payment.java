package org.acme.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.acme.entity.enums.PaymentStatus;

import java.math.BigDecimal;
import java.util.Objects;

@Getter @NoArgsConstructor
@ToString(callSuper = true)
@Entity @Table(name = "payments")
public class Payment extends AbstractEntity{

    @Column(name = "shopcard_pyment_id")
    private String shopcardPaymentId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;

    @NotNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    public Payment(String shopcardPaymentId, @NotNull PaymentStatus status, @NotNull BigDecimal amount ){
        this.shopcardPaymentId = shopcardPaymentId;
        this.status = status;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(payment, payment.shopcardPaymentId) && status == payment.status &&
                Objects.equals(amount, payment.amount);
    }
    @Override
    public int hashCode(){
        return Objects.hash(shopcardPaymentId,status,amount);
    }


}
