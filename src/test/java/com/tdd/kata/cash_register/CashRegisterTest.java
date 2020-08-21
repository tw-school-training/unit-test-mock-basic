package com.tdd.kata.cash_register;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CashRegisterTest {
    @Test
    public void should_trigger_print_when_process_given_printer_to_cash_register() {
        //given
        Printer mockPrinter = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(mockPrinter);
        Purchase purchase = new Purchase();
        //when
        cashRegister.process(purchase);
        //then
        verify(mockPrinter).print(any());
    }

    @Test
    public void should_trigger_print_with_purchase_content_when_process_given_printer_and_purchase_content() {
        //given
        Printer mockPrinter = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(mockPrinter);
        final String ANY_CONTENT = "content2020-08-05T13:49:39.966861";
        Purchase stubPurchase = mock(Purchase.class);
        given(stubPurchase.asString()).willReturn(ANY_CONTENT);
        //when
        cashRegister.process(stubPurchase);
        //then
        verify(mockPrinter).print(ANY_CONTENT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_process_given_empty_purchase() {
        //given
        Printer printer = new Printer();
        CashRegister cashRegister = new CashRegister(printer);
        Purchase stubPurchase = mock(Purchase.class);
        given(stubPurchase.asString()).willReturn("");
        //when
        //then
        cashRegister.process(stubPurchase);
    }

}
