package com.vm.exceptions;

public class SoldOutException extends RuntimeException {
    private String message;

    public SoldOutException(String message) {
        this.message = message;
    }
        public String getMessage () {
            return this.message;
        }
    }