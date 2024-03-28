package com.algoritm.luhnalgorithm;



import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class LuhnService {

    public boolean isValid(String number) {

        int[] digits = number.chars().map(Character::getNumericValue).toArray();

        int sum = IntStream.iterate(digits.length - 2, i -> i >= 0, i -> i -= 2)
                .map(i -> digits[i] * 2)
                .map(digit -> digit > 9 ? digit - 9 : digit)
                .sum() +
                IntStream.iterate(digits.length - 1, i -> i >= 0, i -> i -= 2)
                .map(i -> digits[i])
                .sum();

        return sum % 10 == 0;
    }
}
