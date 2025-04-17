package com.nhan.gscore.domain.exception;

public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException() {
        super("The subject is invalid");
    }
}
