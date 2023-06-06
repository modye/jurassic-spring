package bzh.jurassic.spring.aspect;

import bzh.jurassic.spring.interfaces.DinosaurLoader;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FeedChecker {

    private final DinosaurLoader dinosaurLoader;

    public FeedChecker(DinosaurLoader dinosaurLoader) {
        this.dinosaurLoader = dinosaurLoader;
    }

    @Before("execution(* bzh.jurassic.spring.interfaces.DinosFeeder.feed(..))")
    public void checkStock(JoinPoint joinPoint) {
        // before execution method
        System.out.println("Before feed method");
        String name = (String) joinPoint.getArgs()[0];
        Integer needFeed = dinosaurLoader.getDinosaurs().get(name);
        if (needFeed != null && dinosaurLoader.getMaxStock() - needFeed < 0) {
            System.out.println("Alert !!!!");
        }
    }

}
