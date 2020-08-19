package com.tdd.kata.cash_register;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CashRegisterTest {
    @Test
    public void should_process_execute_printing() {
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
    public void should_process_execute_printing_with_purchase() {
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
