package com.example.agencia_viagens.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class GenericErrorHandler {
    
    private final UsuarioController usuarioController;

    @ExceptionHandler({NotFoundException.class})
    public ModelAndView handleNotFoundException(NotFoundException e) {
        return usuarioController.formCreate();
    }

}
