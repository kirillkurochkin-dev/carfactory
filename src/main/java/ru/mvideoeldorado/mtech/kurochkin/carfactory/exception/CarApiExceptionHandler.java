package ru.mvideoeldorado.mtech.kurochkin.carfactory.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.mvideoeldorado.mtech.kurochkin.carfactory.dto.ErrorDto;

@Slf4j
public class CarApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorDto handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error(ex.getMessage());
        return buildErrorDto(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CarApiException.class)
    public ErrorDto handleCarApiException(CarApiException ex) {
        log.error(ex.getMessage());
        return buildErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ErrorDto buildErrorDto(HttpStatus status, String message) {
        return ErrorDto.of(status.value(), message);
    }
}
