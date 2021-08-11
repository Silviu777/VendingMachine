package com.vm.exceptions;

public class NotFullPaidException extends Throwable {

    public NotFullPaidException(String warning) {
        super(warning);
    }
    public NotFullPaidException() {
        super("Enter the proper amount to make the purchase!");
    }
}
