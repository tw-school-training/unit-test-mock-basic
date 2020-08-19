package com.tdd.kata.cash_register;

import org.junit.Test;

public class CashRegisterTest {
	@Test
	public void should_process_execute_printing() {
		//given
		CashRegister cashRegister = new CashRegister();
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		//verify that cashRegister.process will trigger print
	}

}
