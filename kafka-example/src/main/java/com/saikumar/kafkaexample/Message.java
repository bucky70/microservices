package com.saikumar.kafkaexample;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime timestamp) {
}
