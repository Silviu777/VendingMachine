package com.vm.exceptions;

public class NotSufficientChangeException extends Throwable {
        public NotSufficientChangeException() {
            super("The machine cannot return your change! We apologise for the inconvenience.");
        }
}
