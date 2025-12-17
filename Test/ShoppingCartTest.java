import org.junit.Ignore;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 50);
        assertEquals(1, cart.getItemCount());
        assertEquals(50.0, cart.getTotal());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 5);
        boolean removed = cart.removeItem("Pen");

        assertTrue(removed);
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotal());
    }


    @Disabled
    @Test
    public void testDiscountAtBoundary_WRONG() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("A", 40);
        cart.addItem("B", 60);

        double discounted = cart.getTotalWithDiscount();

        assertEquals(90.0, discounted);
    }

    @Test
    public void testDiscountAboveThreshold() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop Bag", 120);

        double discounted = cart.getTotalWithDiscount();

        assertEquals(108.0, discounted);
    }

    @Test
    public void testCalculateDiscountedTotal_ExactOneHundred() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Gold", 100.0);
        assertEquals(100.0, cart.getTotalWithDiscount(), 0.01);
    }


    @Test
    public void testUpdateItemPrice_ShouldChangePrice() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Book", 50);
        cart.updateItemPrice("Book", 80);

        assertEquals(80.0, cart.getTotal());
    }

    @Test
    public void testUpdateItemPrice_ShouldNotChangeCount() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Pen", 10);
        cart.updateItemPrice("Pen", 20);

        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testUpdateItemPrice_ItemNotFound_ShouldDoNothing() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Notebook", 30);
        cart.updateItemPrice("Eraser", 5);

        assertEquals(30.0, cart.getTotal());
    }

    // added tests for increasing coverage

    /**
     * Ensures removeItem returns false when the item is missing,
     * covering the 'false' branch of the contain check and line 17.
     */

    @Test
    public void testRemoveItem_ItemNotFound_ShouldReturnFalse() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 50);
        boolean removed = cart.removeItem("Pen");

        assertFalse(removed);
        assertEquals(1, cart.getItemCount());
    }

    /**
     * Tests basic getters of the Item class to ensure the model
     * has 100% coverage.
     */

    @Test
    public void testItemClass_BasicFunctionality() {
        Item item = new Item("Laptop", 1200.0);
        assertEquals("Laptop", item.getName());
        assertEquals(1200.0, item.getPrice());
    }
}
