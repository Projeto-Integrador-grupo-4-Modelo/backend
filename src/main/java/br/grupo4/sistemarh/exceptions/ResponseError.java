package br.grupo4.sistemarh.exceptions;

public record ResponseError(String message, org.springframework.http.HttpStatus httpStatus,
                            java.time.LocalDateTime dateTime) {
}
