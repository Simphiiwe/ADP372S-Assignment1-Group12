package za.ac.cput.vehicledealership.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.InventoryFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.service.impl.InventoryServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceTest {

    @Autowired
    private static InventoryServiceImpl inventoryService;
    private static   Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

    private static  Inventory inventory= InventoryFactory.createInventoryFactory(43, InventoryType.USED_INVENTORY,vehicle);
    @Order(1)
    @Test
    void create() {
        Inventory createdInventory= inventoryService.create(inventory);
        assertNotNull(createdInventory);
        System.out.println("Create: " + createdInventory);
    }

    @Order(2)
    @Test
    void read() {
        Inventory readVehicle = inventoryService.read(inventory.getInventoryId());
        assertNotNull(readVehicle);
        System.out.println("Read: " + readVehicle);
    }

    @Order(3)
    @Test
    void update() {
        Inventory updatedInventory= new Inventory.Builder()
                .copy(inventory)
                .setQuantity(221)
                .build();
        assertNotNull(inventoryService.update(updatedInventory));
        System.out.println("Update: " + updatedInventory);

    }

    @Order(5)
    @Test
    void delete() {
        boolean success = inventoryService.delete(inventory.getInventoryId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(inventoryService.getAll());
        assertEquals(1, inventoryService.getAll().size());
    }
}