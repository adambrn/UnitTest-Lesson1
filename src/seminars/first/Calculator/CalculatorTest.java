package seminars.first.Calculator;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;

public class CalculatorTest {
    public static void main(String[] args) {
        // 100 оплата 10 дисконт
        double discountedAmount = Calculator.calculatingDiscount(100.0, 10.0);
        assertThat(discountedAmount).isEqualTo(90.0);

        // 50 оплата 25 дисконт
        discountedAmount = Calculator.calculatingDiscount(50.0, 25.0);
        Assertions.assertThat(discountedAmount).isEqualTo(37.5);

        // 75 оплата 0 дисконт
        discountedAmount = Calculator.calculatingDiscount(75.0, 0.0);
        Assertions.assertThat(discountedAmount).isEqualTo(75.0);

        // Неверная скидка
        Assertions.assertThatThrownBy(() -> Calculator.calculatingDiscount(50.0, 150.0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Скидка должна быть между 0 и 100");
    }
}