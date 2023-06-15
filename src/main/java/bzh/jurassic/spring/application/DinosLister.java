package bzh.jurassic.spring.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Profile("Breizhcamp")
public class DinosLister {

    int securityLimit;

    public DinosLister(
            @Value("${bzh.jurassic.security-limit}") int securityLimit
    ){
        this.securityLimit = securityLimit;
    }
    public List<String> findAllDinos() {
        return List.of("T-Rex", "Velociraptor", "Poule");
    }
}
