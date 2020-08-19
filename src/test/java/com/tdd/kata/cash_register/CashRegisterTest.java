package com.tdd.kata.cash_register;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CashRegisterTest {
    @Test
    public void should_process_execute_printing() {
        //given
        Printer spyPrinter = spy(new Printer());
        CashRegister cashRegister = new CashRegister(spyPrinter);
        Purchase purchase = new Purchase();
        //when
        cashRegister.process(purchase);
        //then
        verify(spyPrinter).print(any());
    }

    @Test
    public void should_process_execute_printing_with_purchase() {
        //given
        Printer spyPrinter = spy(new Printer());
        CashRegister cashRegister = new CashRegister(spyPrinter);
        final String ANY_CONTENT = "content2020-08-05T13:49:39.966861";
        Purchase stubPurchase = mock(Purchase.class);
        given(stubPurchase.asString()).willReturn(ANY_CONTENT);
        //when
        cashRegister.process(stubPurchase);
        //then
        verify(spyPrinter).print(ANY_CONTENT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_process_throw_exception_given_empty_purchase() {
        //given
        Printer printer = new Printer();
        CashRegister cashRegister = new CashRegister();
        Purchase stubPurchase = mock(Purchase.class);
        given(stubPurchase.asString()).willReturn("");
        //when
        //then
        cashRegister.process(stubPurchase);
    }

}
