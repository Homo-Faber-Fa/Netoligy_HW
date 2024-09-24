package ru.netology.springbootrest.handler;

import ru.netology.springbootrest.exception.InvalidCredentials;
import ru.netology.springbootrest.exception.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    // Шаг 4. Теперь, когда весь код у вас готов, вам нужно написать обработчики ошибок, которые выкидывает сервис AuthorizationService.
    @ExceptionHandler(InvalidCredentials.class)
    @ResponseBody
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials invalidCredentials) {
        return new ResponseEntity<>(invalidCredentials.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseBody
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser unauthorizedUser) {
        return new ResponseEntity<>(unauthorizedUser.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
