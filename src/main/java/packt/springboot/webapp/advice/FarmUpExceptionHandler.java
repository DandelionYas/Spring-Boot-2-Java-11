package packt.springboot.webapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import packt.springboot.webapp.exception.SignupFormException;

/**
 * An Interceptor class that contains exception handlers
 * Its exception handlers are annotated with @ResponseStatus, @ExceptionHandler, @RequestMapping
 * Manages Exception at the web application level
 */
@ControllerAdvice
public class FarmUpExceptionHandler {
	
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@GetMapping("/farm/error/null")
	public String throwNullException(Exception e) {
		System.out.println(e.getClass());
		return "mst_farm_null_exception";
	}
	
	@ExceptionHandler(value = NumberFormatException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@GetMapping("/farm/error/format")
	public String throwFormatException(Exception e) {
		System.out.println(e.getClass());
		return "mst_farm_format_exception";
	}
		
	@ExceptionHandler(value = SignupFormException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@GetMapping("/signup/error")
	public String throwSignupFormException(Exception e) {
		return "mst_signup_exception";
	}
}