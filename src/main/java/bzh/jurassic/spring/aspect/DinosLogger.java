package bzh.jurassic.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DinosLogger {

    @Before("execution(* bzh.jurassic.spring.interfaces.DinosFeederServiceImpl.*(..))")
    public void logger(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName);
    }

}
