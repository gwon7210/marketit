package com.test.marketit.dto.orders;


import com.test.marketit.domain.OrderProducts;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class OrderProductsResDto {

    private String name;;

    private int price;;

    public OrderProductsResDto(OrderProducts orderProducts){
        this.name = orderProducts.getName();
        this.price = orderProducts.getPrice();
    }
}
