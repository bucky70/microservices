package com.saikumar.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
