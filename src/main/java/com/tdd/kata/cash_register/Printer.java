package com.tdd.kata.cash_register;

public class Printer {
	public boolean hasBeenCalledPrint;

	public void print(String content) {
		hasBeenCalledPrint = true;
		// send message to a real printer
	}
}
