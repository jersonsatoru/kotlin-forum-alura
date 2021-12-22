package com.jersonsatoru.aluraone.exceptions

import javax.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice()
class ExceptionsHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(exception: NotFoundException, request: HttpServletRequest): ErrorDTO =
            ErrorDTO(exception.message, request.servletPath)

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handle500(request: HttpServletRequest, exception: RuntimeException): ErrorDTO =
            ErrorDTO(exception.message ?: "Internal server error", request.servletPath)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleBeanValidation(
            exception: MethodArgumentNotValidException,
            request: HttpServletRequest
    ): ErrorDTO =
            ErrorDTO(
                    "Invalid Argument",
                    request.servletPath,
                    exception.bindingResult.fieldErrors.fold(mutableMapOf<String, String?>()) {
                            acc,
                            item ->
                        acc.put(item.field, item.defaultMessage)
                        acc
                    }
            )
}
