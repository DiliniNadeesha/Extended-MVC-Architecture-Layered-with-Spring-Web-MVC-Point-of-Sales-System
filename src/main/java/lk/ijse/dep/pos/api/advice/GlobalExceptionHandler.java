package lk.ijse.dep.pos.api.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public String GlobalExceptionHandlerMethod(){
//        return "CALL DEP4 IMMEDIATELY";
//    }

//    @ExceptionHandler(ResponseStatusException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String globalResponseStatusExceptionHandlerMethod(){
//        return "Pissuda oyata";
//    }
}
