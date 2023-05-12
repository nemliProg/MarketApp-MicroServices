package ma.codipster.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import ma.codipster.inventoryservice.dto.StockCheckRequest;
import ma.codipster.inventoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    public ResponseEntity<Boolean> isInStock(@PathVariable("sku-code") String skuCode){
        return ResponseEntity.ok(inventoryService.isInStock(skuCode));
    }

    @PostMapping
    public ResponseEntity<Boolean> isInStock(@RequestBody StockCheckRequest stockCheckRequest){
        return ResponseEntity.ok(inventoryService.isInStock(stockCheckRequest));
    }
}
