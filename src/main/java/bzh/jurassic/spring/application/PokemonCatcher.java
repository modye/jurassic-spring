package bzh.jurassic.spring.application;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("Devoxx")
public class PokemonCatcher {

    public List<String> gottaCatchEmAll() {
        return List.of("Carapuce");
    }
}
