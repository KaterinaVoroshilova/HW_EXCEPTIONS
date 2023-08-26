import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(11, "книга", 580);
    Product product2 = new Product(222, "футболка", 950);

    Product product3 = new Product(55, "шорты", 700);

    @Test
    public void testRemoveNotFound() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-100);
        });
    }

    @Test
    public void testRemove() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product3};
        Product[] actual = repo.remove(222);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.add(product3);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddAlreadyExists() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product2);
        });
    }
}
