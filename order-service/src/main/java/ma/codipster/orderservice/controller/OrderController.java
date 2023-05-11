package ma.codipster.orderservice.controller;

import lombok.RequiredArgsConstructor;
import ma.codipster.orderservice.dto.order.OrderRequest;
import ma.codipster.orderservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Order Service is up and running");
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest){

        orderService.placeOrder(orderRequest);

        return ResponseEntity.created(URI.create("/api/order")).body("Order Placed Successfully");
    }
}
