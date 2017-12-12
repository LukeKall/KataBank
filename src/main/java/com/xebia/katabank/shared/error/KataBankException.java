package com.xebia.katabank.shared.error;

public class KataBankException extends Exception {
    public KataBankException() { super(); }
    public KataBankException(String message) { super(message); }
    public KataBankException(String message, Throwable cause) { super(message, cause); }
    public KataBankException(Throwable cause) { super(cause); }
}
