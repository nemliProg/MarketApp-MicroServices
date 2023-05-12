package ma.codipster.inventoryservice;

import ma.codipster.inventoryservice.model.Inventory;
import ma.codipster.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return (args) -> {
			inventoryRepository.save(new Inventory("SKU-1", 10));
			inventoryRepository.save(new Inventory("SKU-2", 20));
			inventoryRepository.save(new Inventory("SKU-3", 30));
			inventoryRepository.save(new Inventory("SKU-4", 40));
			inventoryRepository.save(new Inventory("SKU-5", 50));
		};
	}
}
