package br.edu.ibmec.todo.exception;

import lombok.Data;

@Data
public class ValidationError {
    private String field;
    private String message;
}
