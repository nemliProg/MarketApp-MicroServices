package ma.codipster.orderservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.codipster.orderservice.dto.order.OrderRequest;
import ma.codipster.orderservice.mappers.OrderLineItemsMapper;
import ma.codipster.orderservice.model.Order;
import ma.codipster.orderservice.model.OrderLineItems;
import ma.codipster.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineItemsMapper orderLineItemsMapper;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderLineItemsMapper.OrderLineItemsDtoListToOrderLineItemsList(orderRequest.getOrderLineItemsList());
        order.setOrderLineItems(orderLineItemsList);

        orderRepository.save(order);
    }


}
