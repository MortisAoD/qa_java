import com.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFeline {
    private Feline feline;

    @BeforeEach
    public void setUp() {
        feline = new Feline();
    }

    @Test
    @DisplayName("Проверка семейства")
    public void getFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка потомства")
    public void getKittensTest() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка количества потомства")
    public void getKittensCountTest() {
        int expected = 5;
        int actual = feline.getKittens(5);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка пищи")
    public void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }
}
