package com.test.marketit.dto.orders;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class OrdersReqDto {

    @NotNull
    @Schema(description = "주문 상품 리스트")
    private List<OrderProductsReqDto> orderProductsReqDtos;

    @NotNull
    @Schema(description = "고객 이름")
    private String userName;
}
