package com.tdd.kata.cash_register;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CashRegisterTest {
    @Test
    public void should_trigger_print_when_process_given_printer_to_cash_register() {
        //given
        SpyPrinter spyPrinter = new SpyPrinter();
        CashRegister cashRegister = new CashRegister(spyPrinter);
        Purchase purchase = new Purchase();
        //when
        cashRegister.process(purchase);
        //then
        assertTrue(spyPrinter.hasBeenCalledPrint);
    }

    @Test
    public void should_trigger_print_with_purchase_content_when_process_given_printer_and_purchase_content() {
        //given
        SpyPrinter spyPrinter = new SpyPrinter();
        CashRegister cashRegister = new CashRegister(spyPrinter);
        final String ANY_CONTENT = "content2020-08-05T13:49:39.966861";
        StubPurchase stubPurchase = new StubPurchase(ANY_CONTENT);
        //when
        cashRegister.process(stubPurchase);
        //then
        assertTrue(spyPrinter.hasBeenCalledPrint);
        assertEquals(ANY_CONTENT, spyPrinter.content);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_process_given_empty_purchase() {
        //given
        SpyPrinter spyPrinter = new SpyPrinter();
        CashRegister cashRegister = new CashRegister(spyPrinter);
        StubPurchase stubPurchase = new StubPurchase("");
        //when
        //then
        cashRegister.process(stubPurchase);
    }

    private class StubPurchase extends Purchase {
        private String stubContent;

        private StubPurchase(String stubContent) {
            this.stubContent = stubContent;
        }

        @Override
        public String asString() {
            return stubContent;
        }
    }

    private class SpyPrinter extends Printer {
        boolean hasBeenCalledPrint;
        String content;

        @Override
        public void print(String content) {
            this.content = content;
            hasBeenCalledPrint = true;
            super.print(content);
        }
    }
}
