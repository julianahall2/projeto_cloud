package br.edu.ibmec.todo.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ValidationMessageErrors {
    private String message = "Existem erros na requisições";
    private List<ValidationError> errors = new ArrayList<>();
}
