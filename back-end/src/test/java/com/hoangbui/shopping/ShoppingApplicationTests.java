package com.hoangbui.shopping;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShoppingApplicationTests {
    Calculator underTesCalculator = new Calculator();

    @Test
    void isShotNumber() {
        //give
        int numberOne = 10;
        int numberTwo = 20;
//        when
        int result = underTesCalculator.add(numberOne, numberTwo);
        // then
        int expected = 30;
        assertThat(result).isEqualTo(expected);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }

}
