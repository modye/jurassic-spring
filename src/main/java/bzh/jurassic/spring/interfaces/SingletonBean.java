package bzh.jurassic.spring.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class SingletonBean {

    private final BeanRequest beanRequest;

    public SingletonBean(BeanRequest beanRequest) {
        this.beanRequest = beanRequest;
    }

    public void titi() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        beanRequest.toto(request);
    }
}
