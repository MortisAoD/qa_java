import com.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestCat {
    private static final String EXPECTED_SOUND = "Мяу";
    private static final String TEST_FAILURE_MESSAGE = "Некорректный результат теста";

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("Проверка голоса")
    public void getSoundTest() {
        String expected = EXPECTED_SOUND;
        String actual = cat.getSound();
        assertEquals(expected, actual, TEST_FAILURE_MESSAGE);
    }

    @Test
    @DisplayName("Проверка пищи")
    public void getFoodTest() throws Exception {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFoodList);
        List<String> expected = expectedFoodList;
        List<String> actual = cat.getFood();
        assertEquals(expected, actual, TEST_FAILURE_MESSAGE);
    }
}