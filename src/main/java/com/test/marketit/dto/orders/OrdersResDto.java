package com.test.marketit.dto.orders;

import com.test.marketit.domain.OrderProducts;
import com.test.marketit.domain.Orders;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class OrdersResDto {

    private Long id;

    @Schema(description = "고객 이름")
    private String userName;

    @Schema(description = "주문 완료 여부")
    private Boolean isCompleted;

    @Schema(description = "등록일")
    private Timestamp registerDate;

    @Schema(description = "주문 상품 리스트")
    private List<OrderProductsResDto> orderProducts;

    public OrdersResDto(Orders orders){
        this.id = orders.getId();
        this.userName = orders.getUserName();
        this.isCompleted = orders.getIsCompleted();
        this.registerDate = orders.getRegisterDate();
        this.orderProducts = orders.getOrderProducts().stream()
                .map(OrderProductsResDto::new)
                .collect(Collectors.toList());
    }
}
