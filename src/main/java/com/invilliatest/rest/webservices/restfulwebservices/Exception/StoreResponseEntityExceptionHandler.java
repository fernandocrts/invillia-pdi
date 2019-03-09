package com.invilliatest.rest.webservices.restfulwebservices.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.invilliatest.rest.webservices.restfulwebservices.payment.PaymentNotFoundException;

/*ControllerAdivice, para ser compartilhado para os outros controlers. 
 *RestController, para padronizar a exceção como uma resposta interpretável por outros consumers deste recurso*/
@ControllerAdvice
@RestController
public class StoreResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public final ResponseEntity<Object> handlePaymentNotFoundException(Exception ex, WebRequest webRequest){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
