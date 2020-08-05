package com.tdd.kata.cash_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
	@Test
	void should_process_execute_printing() {
		//given
		SpyPrinter spyPrinter = new SpyPrinter();
		CashRegister cashRegister = new CashRegister(spyPrinter);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		assertTrue(spyPrinter.hasBeenCalledPrint);
	}

	private class SpyPrinter extends Printer {
		public boolean hasBeenCalledPrint;

		@Override
		public void print(String content) {
			hasBeenCalledPrint = true;
			super.print(content);
		}
	}
}
