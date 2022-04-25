package com.suellenoliveiraprog.aikoprova.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }

}
