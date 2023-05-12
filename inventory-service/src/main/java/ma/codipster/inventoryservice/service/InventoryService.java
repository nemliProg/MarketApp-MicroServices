package ma.codipster.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import ma.codipster.inventoryservice.dto.StockCheckRequest;
import ma.codipster.inventoryservice.model.Inventory;
import ma.codipster.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    public boolean isInStock(StockCheckRequest stockCheckRequest) {
        boolean isInStock = false;
        Inventory inventory = null;
        if (stockCheckRequest != null) {
            inventory = inventoryRepository.findBySkuCode(stockCheckRequest.getSkuCode()).orElse(null);
        }
        if (inventory != null) {
            isInStock = inventory.getQuantity() >= stockCheckRequest.getQuantity();
        }
        return isInStock;
    }

}
