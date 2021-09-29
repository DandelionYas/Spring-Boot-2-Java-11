package packt.springboot.webapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
@Order(3)
public class ValidateAspect {

	@Pointcut("execution(public * packt.springboot.webapp.controller.HarvestFormController.submitForm(..))")
	public void loginControllerPointcut() { }

	@Around("loginControllerPointcut()")
	public String authenticate(ProceedingJoinPoint pjp) {

		log.info("Validating harvested product information...");

		Object[] args = pjp.getArgs();
		Integer id = (Integer) args[1];

		if (id == null || id <= 0) {
			id = 100;
		}
		args[1] = id;

		String destination = null;
		try {
			destination = (String) pjp.proceed(args);
		} catch (Throwable e) {
			log.fatal(e.getMessage());
		}

		log.info("Harvest information is now saved and displayed at " + destination);
		return destination;
	}
}