package com.algoritm.luhnalgorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class LuhnServiceTests {

    @Autowired
    private LuhnService luhnService;

    private String cardNumber1 = "6011566926687256";
    private String cardNumber2 = "370642420667124";
    private String cardNumber3 = "5417438903761250";
    private String cardNumber4 = "4518377421351212";

    @Test
    void luhnTest() {
        Assertions.assertTrue(luhnService.isValid(cardNumber1));
        System.out.println(cardNumber1 + " -> " + luhnService.isValid(cardNumber1));
        Assertions.assertTrue(luhnService.isValid(cardNumber2));
        System.out.println(cardNumber2 + " -> " + luhnService.isValid(cardNumber2));
        Assertions.assertTrue(luhnService.isValid(cardNumber3));
        System.out.println(cardNumber3 + " -> " + luhnService.isValid(cardNumber3));
        Assertions.assertFalse(luhnService.isValid(cardNumber4));
        System.out.println(cardNumber4 + " -> " + luhnService.isValid(cardNumber4));
    }

}
