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
        String name = (String) joinPoint.getArgs()[0];
        Integer needFeed = dinosaurLoader.getDinosaurs().get(name);
        if (needFeed != null && dinosaurLoader.getMaxStock() - needFeed < 0) {
            System.out.println("Alert !!!!");
        }
        return joinPoint.proceed(); // Proceed with the original method invocation
    }

}
