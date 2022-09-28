package com.main.server.service.order;

import com.main.server.domain.Member;
import com.main.server.domain.Order;
import com.main.server.domain.OrderLine;
import com.main.server.domain.repository.OrderRepository;
import com.main.server.service.ProductService;
import com.main.server.service.member.MemberService;
import com.main.server.service.order.dto.OrderProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void post(Member member, List<OrderProducts> products){

        Order order = new Order(member);
        products.stream()
                .map(orderProducts -> new OrderLine(orderProducts.getProduct(), orderProducts.getProductCount()))
                .forEach(orderLine -> order.appendOrderLine(orderLine));

        orderRepository.save(order);

    }
}