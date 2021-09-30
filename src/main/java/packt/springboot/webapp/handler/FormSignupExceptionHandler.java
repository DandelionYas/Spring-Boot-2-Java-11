package packt.springboot.webapp.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import packt.springboot.webapp.exception.MissingResourceException;
import packt.springboot.webapp.model.Profile;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FormSignupExceptionHandler {
	
	@ExceptionHandler(value = MissingResourceException.class)
	@ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR)
	public List<Profile> resolveMissingResource(){
		return new ArrayList<>();
	}

}