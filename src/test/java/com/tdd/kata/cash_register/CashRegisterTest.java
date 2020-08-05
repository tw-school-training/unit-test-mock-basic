package com.tdd.kata.cash_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class CashRegisterTest {
	@Test
	void should_process_execute_printing() {
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
	void should_process_execute_printing_with_purchase() {
		//given
		Printer spyPrinter = spy(new Printer());
		CashRegister cashRegister = new CashRegister(spyPrinter);
		final String ANY_CONTENT = "content2020-08-05T13:49:39.966861";
		StubPurchase stubPurchase = new StubPurchase(ANY_CONTENT);
		//when
		cashRegister.process(stubPurchase);
		//then
		verify(spyPrinter).print(ANY_CONTENT);
	}

	@Test
	void should_process_throw_exception_given_empty_purchase() {
		//given
		Printer printer = new Printer();
		CashRegister cashRegister = new CashRegister();
		StubPurchase stubPurchase = new StubPurchase("");
		//when
		//then
		assertThrows(IllegalArgumentException.class, () -> {
			cashRegister.process(stubPurchase);
		});
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
}
