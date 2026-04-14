package org.example.strategy.chain;

public class FeeCalculatorMain {

    public static void main(String[] args) {
        FeeCalculatorService service = new FeeCalculatorService();

        service.process(PaymentMethod.VISA_CREDIT, 1000, 5);
        System.out.println("------------------");
        service.process(PaymentMethod.VISA_DEBIT, 1000, 5);

    }
}
