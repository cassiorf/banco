package com.example.banco.api.exception;

import com.example.banco.domain.exception.FormatoInvalidoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.example.banco.api")
public class ExceptionConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionConfig.class);

    @ResponseStatus(value = HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflictHandler(DataIntegrityViolationException e) {
        LOGGER.warn("Detectador violação de integridade de dados: {}", e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(FormatoInvalidoException.class)
    public void formatoInvalidoHandler(FormatoInvalidoException e) {
        LOGGER.warn("Dado com formato invalido: {}", e.getMessage());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    public void unexpectedExceptionHandler(Exception e) {
        LOGGER.warn("Erro de servidor: {}", e.getMessage());
    }
}

