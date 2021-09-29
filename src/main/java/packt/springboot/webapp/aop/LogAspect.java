package packt.springboot.webapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
@Order(0)
public class LogAspect {
	
		@Pointcut("within(packt.springboot.webapp.controller..*)")
	    public void applicationPackagePointcut() { }
		
		@After("applicationPackagePointcut()")
		public void logController(JoinPoint joinPoint) {
		     log.info("Accessed the controller: " + joinPoint.getTarget());
		}
}