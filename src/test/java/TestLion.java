import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestLion {
    @Mock
    Feline feline;

    @Test
    @DisplayName("Проверка потомства")
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        when(feline.getKittens()).thenReturn(3);
        int expected = 3;
        int actual = lion.getKittens();
        assertEquals(expected, actual, "Некорректный результат теста");
    }

    @Test
    @DisplayName("Проверка пищи")
    public void getFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        verify(feline).getFood("Хищник");
    }

    @Test
    public void getSexExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("samec", feline);
            lion.doesHaveMane();
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}

