package com.test.marketit.controller;


import com.test.marketit.common.CommController;
import com.test.marketit.common.exception.BaseException;
import com.test.marketit.dto.orders.OrdersReqDto;
import com.test.marketit.dto.orders.OrdersResDto;
import com.test.marketit.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Tag(name = "마켓잇 과제 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController extends CommController {

    private final OrderService orderService;

    @Operation(summary = "모든 주문 목록조회",responses = {@ApiResponse(content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrdersResDto.class))))})
    @GetMapping("list/all")
    public ResponseEntity findOrdersAll() {
        return SuccessReturn(orderService.findOrdersAll());
    }

    @Operation(summary = "주문 접수", responses = {@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdersReqDto.class)))})
    @PostMapping()
    public ResponseEntity saveOrders(@RequestBody @Valid OrdersReqDto reqDto){
        return SuccessReturn(orderService.saveOrders(reqDto));
    }

    @Operation(summary = "주문 완료", responses = {@ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))})
    @PutMapping("/complete/{orderId}")
    public ResponseEntity updateIsCompleted(@PathVariable Long orderId) throws BaseException {
        return SuccessReturn(orderService.updateIsCompleted(orderId));
    }

    @Operation(summary = "단일 주문 조회",responses = {@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrdersResDto.class)))})
    @GetMapping("/{orderId}")
    public ResponseEntity findOrders(@PathVariable Long orderId) throws BaseException {
        return SuccessReturn(orderService.findOrders(orderId));
    }

    @Operation(summary = "주문 목록조회",responses = {@ApiResponse(content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrdersResDto.class))))})
    @GetMapping("list/{userName}")
    public ResponseEntity findOrdersAllByUserName(@PathVariable String userName) throws BaseException {
        return SuccessReturn(orderService.findOrdersAllByUserName(userName));
    }

}
