package com.test.marketit.service;


import com.test.marketit.common.code.ApiCode;
import com.test.marketit.common.exception.BaseException;
import com.test.marketit.domain.OrderProducts;
import com.test.marketit.domain.Orders;
import com.test.marketit.dto.orders.OrderProductsResDto;
import com.test.marketit.dto.orders.OrdersReqDto;
import com.test.marketit.dto.orders.OrdersResDto;
import com.test.marketit.repository.OrderProductsRepository;
import com.test.marketit.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductsRepository orderProductsRepository;

    @Transactional
    public Long saveOrders(OrdersReqDto reqDto) {

        Orders orders = new Orders(reqDto.getUserName(),  false);
        orderRepository.save(orders);

        List<OrderProducts> orderProducts = reqDto.getOrderProductsReqDtos().stream().
                map(resDto -> OrderProducts.builder()
                        .name(resDto.getName())
                        .price(resDto.getPrice())
                        .orders(orders)
                        .build()).collect(Collectors.toList());

        orderProductsRepository.saveAll(orderProducts);

        return orders.getId();
    }

    @Transactional
    public Long updateIsCompleted(Long orderId) throws BaseException {

         Orders orders =  orderRepository.findById(orderId)
                .orElseThrow(() -> new BaseException(ApiCode.DATA_NOT_FOUND));

        orders.updateIsCompleted(true);
        return orderRepository.save(orders).getId();
    }

    public OrdersResDto findOrders(Long orderId) throws BaseException {
        return new OrdersResDto(orderRepository.findById(orderId).orElseThrow(() -> new BaseException(ApiCode.DATA_NOT_FOUND)));
    }




    public List<OrdersResDto> findOrdersAllByUserName(String userName) {

        List<Orders> orders = orderRepository.findAllByUserName(userName);

        List<OrdersResDto>  ordersResDtos = orders.stream()
                .map(OrdersResDto::new)
                .collect(Collectors.toList());

        return ordersResDtos;
    }

    public List<OrdersResDto> findOrdersAll() {

        List<Orders> orders = orderRepository.findAll();

        List<OrdersResDto>  ordersResDtos = orders.stream()
                .map(OrdersResDto::new)
                .collect(Collectors.toList());

        return ordersResDtos;
    }


}
