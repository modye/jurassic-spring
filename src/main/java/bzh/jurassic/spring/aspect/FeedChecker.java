package bzh.jurassic.spring.aspect;

import bzh.jurassic.spring.interfaces.DinosaurLoader;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FeedChecker {

    private final DinosaurLoader dinosaurLoader;

    public FeedChecker(DinosaurLoader dinosaurLoader) {
        this.dinosaurLoader = dinosaurLoader;
    }

    @Around("execution(* bzh.jurassic.spring.interfaces.DinosFeeder.feed(..))")
    public Object checkStock(ProceedingJoinPoint joinPoint) throws Throwable {
        // before execution method
        System.out.println("Before feed method");
        String name = (String) joinPoint.getArgs()[0];
        Integer needFeed = dinosaurLoader.getDinosaurs().get(name);
        if (needFeed != null && dinosaurLoader.getMaxStock() - needFeed < 0) {
            System.out.println("Alert !!!!");
        }
        Object proceed = joinPoint.proceed();
        // after execution method
        System.out.println("After feed method");

        return proceed;
    }

}
