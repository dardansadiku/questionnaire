package com.dardi.questionnaire.util;

import com.dardi.questionnaire.exception.PaymentException;
import com.dardi.questionnaire.exception.PriceException;
import com.dardi.questionnaire.model.Result;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate {

    public static Result calculate(String price, Long payments) throws PriceException, PaymentException {

        BigDecimal totalPrice = new BigDecimal(price);

        if (totalPrice.compareTo(BigDecimal.valueOf(0)) <= 0){
            throw new PriceException("The price is <= 0");
        }
        if (payments <= 0) {
            throw new PaymentException("The payment is <= 0");
        }

        BigDecimal regularAmount = totalPrice.divide(new BigDecimal(payments), 2, RoundingMode.DOWN);
        BigDecimal finalPrice = regularAmount.multiply(new BigDecimal(--payments));

        return new Result(regularAmount,  totalPrice.subtract(finalPrice));
    }
}