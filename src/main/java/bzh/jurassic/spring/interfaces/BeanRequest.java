package bzh.jurassic.spring.interfaces;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class BeanRequest {
    public void toto(HttpServletRequest request) {
        System.out.println(request);
    }
}
