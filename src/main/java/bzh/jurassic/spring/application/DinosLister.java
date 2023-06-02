package bzh.jurassic.spring.application;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DinosLister {

    public List<String> findAllDinos() {
        return List.of("T-Rex", "Velociraptor", "Poule");
    }
}
