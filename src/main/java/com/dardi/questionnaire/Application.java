package com.dardi.questionnaire;

import com.dardi.questionnaire.exception.PaymentException;
import com.dardi.questionnaire.exception.PriceException;
import com.dardi.questionnaire.model.Result;
import com.dardi.questionnaire.util.Calculate;

import java.util.InputMismatchException;

public class Application {

    public static void main(String[] args) {

        String price;
        Long payments;

        try {
            if (args.length == 0) {
                throw new PriceException("Type a valid price!");
            } else if (args.length == 1){
                throw new PaymentException("Type a valid payment!");
            }

            price = args[0];
            payments = Long.parseLong(args[1]);

            Result returnAmount = Calculate.calculate(price, payments);
            System.out.println(returnAmount);
        } catch (InputMismatchException | PriceException | PaymentException e) {
            System.out.println(e);
        }

    }
}