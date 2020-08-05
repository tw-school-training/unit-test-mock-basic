package com.tdd.kata.cash_register;

public class CashRegister {
	private final Printer printer;

	public CashRegister() {
		this.printer = new Printer();
	}

	void process(Purchase purchase) {
		printer.print(purchase.asString());
	}
}
