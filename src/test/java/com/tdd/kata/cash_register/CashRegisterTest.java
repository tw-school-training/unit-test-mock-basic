package com.tdd.kata.cash_register;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

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
