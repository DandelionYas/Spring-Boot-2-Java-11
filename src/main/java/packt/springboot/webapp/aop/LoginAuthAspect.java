package packt.springboot.webapp.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;
import packt.springboot.webapp.event.LoginAttemptEvent;

@Aspect
@Component
@Log4j2
@Order(1)
public class LoginAuthAspect {
    @Autowired
    private ApplicationEventPublisher farmEventPublisher;

    @Pointcut("execution(public * packt.springboot.webapp.controller.LoginFormController.loginUser(..))")
    public void loginControllerPointcut() {
    }

    @Around("loginControllerPointcut() && args(username, password, redirectAttributes)")
    public String authenticate(ProceedingJoinPoint proceedingJoinPoint, String username, String password, RedirectAttributes redirectAttributes) {
        List<String> validUsers = Arrays.asList("admin@gmail.com", "user@yahoo.com");

        if (validUsers.contains(username.trim())) {
            try {
                log.info("confirmed logged in is user:" + username);
                return  (String) proceedingJoinPoint.proceed();
            } catch (Throwable e) {
                log.info("user:" + username + " is invalid!");
                return  "mst_authentication_error";
            }
        } else {
            farmEventPublisher.publishEvent(new LoginAttemptEvent(this, username, password));
            return "mst_authentication_error";
        }
    }
}
