package com.tdd.kata.cash_register;

import org.junit.Test;

public class CashRegisterTest {
	@Test
	public void should_trigger_print_when_process_given_printer_to_cash_register() {
		//given
		CashRegister cashRegister = new CashRegister();
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		//verify that cashRegister.process will trigger print
	}

}
