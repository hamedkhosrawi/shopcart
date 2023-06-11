package org.acme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address extends AbstractEntity{

    @Column(name = "address_1")
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Size(max = 10)
    @NotNull
    @Column(name = "postcode", length = 10, nullable = false)
    private String postCode;

    @Size(max = 2)
    @NotNull
    @Column(name = "country", length = 2, nullable = false)
    private String country;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(address1, address.address1) &&
                Objects.equals(address2, address.address2) &&
                Objects.equals(city, address.city) &&
                Objects.equals(postCode, address.postCode) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode(){
        return Objects.hash(address1,address2,city,postCode,country);
    }

}
