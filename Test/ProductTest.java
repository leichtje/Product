import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {


    Product p1,p2;

    @BeforeEach
    void setUp() {
        p1 = new Product("00000A","Pipeweed", "Long Bottom Leaf", 600.0);
        p2 = new Product("00000A","Lembas", "Elven Wayfare Bread", 200.0);
    }

    @Test
    void setName() {
        p1.setName("Pipeweed");
        assertEquals("Pipeweed",p1.getName());
    }

    @Test
    void setDescription() {
        p2.setDescription("Elven Wayfare Bread");
        assertEquals("Elven Wayfare Bread",p2.getDescription());
    }

    @Test
    void setID() {
        p1.setID("00000A");
        assertEquals("00000A",p1.getID());
    }

    @Test
    void setCost() {
        p2.setCost(200.0);
        assertEquals(200.0,p2.getCost());
    }

    @Test
    void toCSVDataRecord() {
        assertEquals("00000A, Pipeweed, Long Bottom Leaf, 600.0", p1.toCSVDataRecord());
    }
}