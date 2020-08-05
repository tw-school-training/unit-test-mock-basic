package com.tdd.kata.cash_register;

public class CashRegister {
	private final Printer printer;

	public CashRegister() {
		this.printer = new Printer();
	}
	public CashRegister(Printer printer) {
		this.printer = printer;
	}

	void process(Purchase purchase) throws IllegalArgumentException {
		if (purchase.asString() == null || purchase.asString().isBlank())
			throw new IllegalArgumentException("Purchase is empty");
		printer.print(purchase.asString());
	}
}
